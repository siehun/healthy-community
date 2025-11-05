package io.yue.common;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-04
 * @Description: 响应消息
 */
public enum HttpCode {
    SUCCESS(200, "OK"),
    FORBIDDEN(400, "Client Error"),
    SERVER_ERROR(500, "Internal Server Error");


    private Integer code;
    private String msg;

    HttpCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }


}
