package io.yue.common.result;

import io.yue.common.HttpCode;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-04
 * @Description: 响应消息工厂
 */
public class ResultFacotry {

    public static<T> Result<T> ok() {
        Result<T> result = new Result<>();
        result.setCode(HttpCode.SUCCESS.getCode());
        result.setMsg(HttpCode.SUCCESS.getMsg());
        return result;
    }

    public static<T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(HttpCode.SUCCESS.getCode());
        result.setMsg(HttpCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static<T> Result<T> ok(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(HttpCode.SUCCESS.getCode());
        result.setMsg(message);
        result.setData(data);
        return result;
    }

    public static<T> Result<T> ok(String message) {
        Result<T> result = new Result<>();
        result.setCode(HttpCode.SUCCESS.getCode());
        result.setMsg(message);
        return result;
    }

    public static<T> Result<T> error(HttpCode code) {
        Result<T> result = new Result<>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    public static<T> Result<T> error(HttpCode code, String message) {
        Result<T> result = new Result<>();
        result.setMsg(message);
        result.setCode(code.getCode());
        return result;
    }
}
