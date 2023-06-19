package com.changjiang.monitor.dto.schedule;

import lombok.Data;

import java.io.Serializable;

/**
 * 天调度周期
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Data
public class DayRange implements Serializable {

    /**
     * 开始时间 HH:mm
     */
    private String beginTime;

    /**
     * 结束时间 HH:mm
     */
    private String endTime;
}
