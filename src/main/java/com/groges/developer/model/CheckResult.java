package com.groges.developer.model;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * @Author:xiewt
 * @Description: 检查数据返回模板
 * @Date:Create in 2018/1/31 11:09
 * @Modify By:
 */
@Data
public class CheckResult {
    private int errCode;        // 错误号
    private boolean success;    // 是否成功
    private Claims claims;      //
}
