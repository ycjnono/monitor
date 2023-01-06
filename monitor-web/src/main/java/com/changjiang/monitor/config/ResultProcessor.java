package com.changjiang.monitor.config;

import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.log.Log;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.Result;
import com.changjiang.monitor.utils.RequestIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 统一结果集
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Slf4j
@Aspect
@Component
public class ResultProcessor {

    @Pointcut("execution(* com.changjiang.monitor.api..*.*(..))")
    public void apiCut() {

    }

    /**
     * 增强处理
     *
     * @param call
     * @return
     * @throws Throwable
     */
    @Around("apiCut()")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {
        // requestId
        Result<Object> result = null;
        String requestId = RequestIdUtil.requestId();
        long begin = System.currentTimeMillis();
        Log.topic("Cost").log("begin", begin).info(log);
        try {
            Object proceed = call.proceed();
            result = Result.success(requestId, proceed);
        } catch (Throwable e) {
            String message = CodeEnum.ServerFail.getMessage();
            String code = CodeEnum.ServerFail.getCode();
            if (e instanceof MonitorException) {
                code = ((MonitorException) e).getCode();
                message = e.getMessage();
            }
            result = Result.fail(requestId, code, message);
            Log.topic("RequestFail").log("result", result).fail(log, e);
        }
        long end = System.currentTimeMillis();
        Log.topic("Cost").log("end", end).log("costTime", end - begin).info(log);
        return result;
    }
}
