package com.changjiang.monitor.exception;

import com.changjiang.monitor.result.CodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 异常
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorException extends RuntimeException{

    /**
     * 状态码
     */
    private String code;

    /**
     * 构造
     *
     * @param codeEnum
     */
    public MonitorException(CodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    /**
     * 构造
     *
     * @param codeEnum
     */
    public MonitorException(CodeEnum codeEnum, String message){
        super(message);
        this.code = codeEnum.getCode();
    }
}
