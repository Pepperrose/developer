package com.groges.developer.filter;

import com.groges.developer.config.Constant;
import com.groges.developer.model.CheckResult;
import com.groges.developer.model.ResponseMgr;
import com.groges.developer.util.JwtUtil;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 14:52
 * @Modify By:
 */
public class SignFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String tokenStr = httpServletRequest.getParameter("token");
        if (tokenStr == null || tokenStr.equals("")) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print(ResponseMgr.err());
            printWriter.flush();
            printWriter.close();
            return;
        }

        // 验证JWT的签名，返回CheckResult对象
        CheckResult checkResult = JwtUtil.validateJWT(tokenStr);
        if (checkResult.isSuccess()) {
            Claims claims = checkResult.getClaims();
            // SubjectModel model = GsonUtil.jsonStrToObject(claims.getSubject(), SubjectModel.class);
            // httpServletRequest.setAttribute("tokensub", model);
        }else {
            switch (checkResult.getErrCode()) {
                // 签名过期，返回过期提示码
                case Constant.JWT_ERRCODE_EXPIRE:
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    printWriter.print(ResponseMgr.loginExpire());
                    printWriter.flush();
                    printWriter.close();
                    break;
                // 签名验证不通过
                case Constant.JWT_ERRCODE_FAIL:
                    PrintWriter printWriter2 = httpServletResponse.getWriter();
                    printWriter2.print(ResponseMgr.noAuth());
                    printWriter2.flush();
                    printWriter2.close();
                    break;
                default:
                    break;
            }
        }
    }

    public void destroy() {

    }
}
