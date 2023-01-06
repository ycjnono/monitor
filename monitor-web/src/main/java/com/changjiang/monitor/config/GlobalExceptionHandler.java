package com.changjiang.monitor.config;

import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.Result;
import com.changjiang.monitor.utils.RequestIdUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 *
 * @Author changjiang
 * @Date 2022/12/12 since beijing
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object serverFail(Throwable throwable){
        log.error("SystemFail", throwable);
        return Result.fail(RequestIdUtil.requestId(),CodeEnum.ServerFail.getCode(), CodeEnum.ServerFail.getMessage());
    }

}
