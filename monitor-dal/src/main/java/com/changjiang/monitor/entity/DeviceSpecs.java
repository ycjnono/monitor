package com.changjiang.monitor.entity;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * 设备规格
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Data
@Table(name = "device_specs")
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `device_specs` set `deleted` = true where id = ?")
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
