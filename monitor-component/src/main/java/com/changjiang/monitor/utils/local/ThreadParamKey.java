package com.changjiang.monitor.utils.local;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 线程参数key
 *
 * @Author changjiang
 * @Date 2022/12/11 23:05 since beijing
 */
@Getter
@AllArgsConstructor
public enum ThreadParamKey {

    /**
     * 请求id
     */
    RequestId("requestId"),
    /**
     * 管控台登录用户
     */
    ConsoleUser("ConsoleUser"),
    ;

    /**
     * key
     */
    private final String key;
}
