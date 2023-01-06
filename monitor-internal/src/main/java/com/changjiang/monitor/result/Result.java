package com.changjiang.monitor.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 结果集
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 状态码
     */
    private String code;

    /**
     * 成功标识
     */
    private Boolean success;

    /**
     * 描述
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 成功
     *
     * @param requestId
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String requestId, T data) {
        Result<T> result = new Result<>();
        result.requestId = requestId;
        result.data = data;
        result.success = true;
        result.message = "请求成功";
        result.code = CodeEnum.Success.getCode();
        return result;
    }


    /**
     * 失败
     *
     * @param requestId
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String requestId, String code, String message) {
        Result<T> result = new Result<>();
        result.requestId = requestId;
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }
}
