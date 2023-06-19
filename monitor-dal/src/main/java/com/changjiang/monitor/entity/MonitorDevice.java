package com.changjiang.monitor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

/**
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
@Entity
@Table(name = "monitor_device")
@EqualsAndHashCode(callSuper = true)
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `monitor_device` set `deleted` = true where id = ?")
public class MonitorDevice extends BaseEntity{

    /**
     * 租户id
     */
    private String tenantId;

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
     * 独立监控,不跟随region相关调度
     */
    private Boolean aloneSchedule;

    /**
     * 设备监控周期
     */
    private String scheduleRange;

    /**
     * 下次开启时间
     */
    private Date nextOpen;

}
