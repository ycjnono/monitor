package com.changjiang.monitor.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备规格
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceSpecs extends BaseEntity{

    /**
     * id
     */
    private String id;

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格说明
     */
    private String remark;

    /**
     * 监控规格id
     */
    private String monitorRuleId;

    /**
     * 详细配置
     */
    private String config;
}
