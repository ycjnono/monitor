package com.changjiang.monitor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

/**
 * 租户
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@Entity
@Table(name = "tenant")
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `tenant` set `deleted` = true where id = ?")
@EqualsAndHashCode(callSuper = true)
public class Tenant extends BaseEntity{

    /**
     * 租户名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 管理员手机号，用以激活，发送默认账号等用途
     */
    @Column(name = "manage_phone_number")
    private String managePhoneNumber;

    /**
     * 管理员邮箱
     */
    @Column(name = "manage_email")
    private String manageEmail;

    /**
     * 账号域
     */
    @Column(name = "domain")
    private String domain;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 过期时间
     */
    @Column(name = "expired_time")
    private Date expiredTime;

}
