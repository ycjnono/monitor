package com.changjiang.monitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 监控报告
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
@Entity
@Table(name = "monitor_report")
@EqualsAndHashCode(callSuper = true)
public class MonitorReport extends BaseEntity {

    private String tenantId;

    private String regionId;

    private String title;

    private String type;

    private String sendStatus;

    private Date reportTime;


}
