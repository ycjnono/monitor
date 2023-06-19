package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.BaseDTO;
import com.changjiang.monitor.dto.schedule.ScheduleRange;
import com.changjiang.monitor.dto.status.MonitorScheduleStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 监控设备
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorDeviceDTO extends BaseDTO {

    /**
     * 区域id
     */
    private String regionId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备自定义名称
     */
    private String customName;

    /**
     * 设备规格id
     */
    private String specsId;

    /**
     * 是否根据设备监控周期自动开闭
     */
    private Boolean auto;

    /**
     * 设备调度状态
     */
    private MonitorScheduleStatus status;

    /**
     * 上次调度时间
     */
    private Date scheduleTime;

    /**
     * 独立监控,不跟随region相关调度
     */
    private Boolean aloneSchedule;

    /**
     * 设备监控周期
     */
    private ScheduleRange scheduleRange;

    /**
     * 下次开启时间
     */
    private Date nextOpen;
}
