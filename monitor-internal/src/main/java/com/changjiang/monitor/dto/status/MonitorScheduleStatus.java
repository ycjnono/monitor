package com.changjiang.monitor.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 监控调度状态
 *
 * @Author changjiang
 * @Date 2023/6/19 23:44 since beijing
 */
@Getter
@AllArgsConstructor
public enum MonitorScheduleStatus {

    /**
     * 等待调度
     */
    Waiting,
    /**
     * 调度中
     */
    Scheduling,
    /**
     * 调度超时
     */
    TimeOut,
    /**
     * 自动关闭调度,超过调度截至日期,后续不再开启
     */
    OverTimeClosed,
    /**
     * 自动关闭调度,根据调度配置决定下次是否开启
     */
    AutoClosed,
    /**
     * 手动关闭调度,后续不再开启
     */
    Closed,
    ;
}
