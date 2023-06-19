package com.changjiang.monitor.dto.region;

import com.changjiang.monitor.base.BaseDTO;
import com.changjiang.monitor.dto.schedule.ScheduleRange;
import com.changjiang.monitor.dto.status.MonitorScheduleStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 监控区域对象
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorRegionDTO extends BaseDTO {

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 区域id
     */
    private String regionId;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域自定义名称
     */
    private String customName;

    /**
     * 调度状态
     */
    private MonitorScheduleStatus status;

    /**
     * 开闭周期
     */
    private ScheduleRange scheduleRange;

    /**
     * 是否按照周期自动开闭
     */
    private Boolean auto;
}
