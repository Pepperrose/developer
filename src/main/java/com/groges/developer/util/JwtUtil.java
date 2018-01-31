package com.groges.developer.util;

import com.groges.developer.config.Constant;
import com.groges.developer.model.CheckResult;
import io.jsonwebtoken.*;
import org.apache.shiro.codec.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 11:15
 * @Modify By:
 */
public class JwtUtil {
    /**
     * 签发JWT
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id ,String subject ,long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)              //JWT_ID
                .setSubject(subject)    //主题
                .setIssuedAt(now)       //签发时间
                .signWith(signatureAlgorithm ,secretKey);     // 签名算法以及密匙

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    public static CheckResult validateJWT(String jwtstr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = paresJWT(jwtstr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(Constant.JWT_ERRCODE_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 生成签名密钥
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodeKey = Base64.decode(Constant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodeKey ,0 ,encodeKey.length ,"AES");
        return key;
    }

    /**
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims paresJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

//    public static String generalSubject()
}
