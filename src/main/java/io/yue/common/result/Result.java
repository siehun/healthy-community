package io.yue.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: siehun
 * @CreateTime: 2025-11-04
 * @Description: 响应消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    public Result(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
