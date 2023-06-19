package com.changjiang.monitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区域监控表
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
@Entity
@Table(name = "monitor_region")
@EqualsAndHashCode(callSuper = true)
public class MonitorRegion extends BaseEntity{

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
     * 开闭周期
     */
    private String scheduleRange;

    /**
     * 是否按照周期自动开闭
     */
    private Boolean auto;
}
