package com.groges.developer.model;

import com.groges.developer.util.GsonUtil;
import lombok.Data;

/**
 * @Author:xiewt
 * @Description: 公共数据返回模板
 * @Date:Create in 2018/1/31 10:58
 * @Modify By:
 */
@Data
public class CommonResult {
    private int code;       //状态码
    private Object data;    //返回数据
    private String msg;     //返回信息
    private String token;   //返回token

    public CommonResult() {
        super();
    }

    public CommonResult(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, Object data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public CommonResult(int code, Object data, String msg, String token) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.token = token;
    }

    /**
     * 请求返回数据处理
     * @return
     */
    public String general() {
        return GsonUtil.objectToJsonStr(this);
    }
}
