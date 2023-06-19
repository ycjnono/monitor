package com.changjiang.monitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 监控规则
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
@Entity
@Table(name = "monitor_rule")
@EqualsAndHashCode(callSuper = true)
public class MonitorRule extends BaseEntity{
}
