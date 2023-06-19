package com.changjiang.monitor.dto.schedule;

import lombok.Getter;

/**
 * 调度维度
 *
 * @Author changjiang
 * @Date 2023/6/20 since beijing
 */
@Getter
public enum Timing {
    /**
     * 每天
     */
    Day,
    /**
     * 每周
     */
    Week,
    /**
     * 一次性
     */
    Once,
    /**
     * 不调度
     */
    None,
}
