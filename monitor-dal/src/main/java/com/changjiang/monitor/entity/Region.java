package com.changjiang.monitor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区域
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@Entity
@Table(name = "region")
@EqualsAndHashCode(callSuper = true)
public class Region extends BaseEntity{

    /**
     * 租户id
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 封面图
     */
    @Column(name = "cover")
    private String cover;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 管理员id
     */
    @Column(name = "manager")
    private String manager;

    /**
     * 父区域id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;
}
