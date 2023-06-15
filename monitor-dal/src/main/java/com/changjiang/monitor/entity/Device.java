package com.changjiang.monitor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * 设备
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@Entity
@Table(name = "device")
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `device` set `deleted` = true where id = ?")
@EqualsAndHashCode(callSuper = true)
public class Device extends BaseEntity{

    /**
     * 租户id
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 区域id
     */
    @Column(name = "region_id")
    private String regionId;

    /**
     * 设备名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 规格id
     */
    @Column(name = "specs_id")
    private String specsId;

    /**
     * 设备类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 封面图
     */
    @Column(name = "cover")
    private String cover;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 设备ip
     */
    @Column(name = "ip")
    private String ip;

    /**
     * 详细配置
     */
    @Column(name = "config")
    private String config;

    /**
     * 制造商
     */
    @Column(name = "manufacturer")
    private String manufacturer;

    /**
     * 连接信息
     */
    @Column(name = "connect_config")
    private String connectConfig;
}
