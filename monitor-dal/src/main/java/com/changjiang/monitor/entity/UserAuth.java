package com.changjiang.monitor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

/**
 * 用户登录信息
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Data
@Entity
@Table(name = "user_auth")
@EqualsAndHashCode(callSuper = true)
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `user_auth` set `deleted` = true where id = ?")
public class UserAuth extends BaseEntity{

    /**
     * 租户id
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 登录token
     */
    @Column(name = "token")
    private String token;

    /**
     * 三方id
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * token失效时间
     */
    @Column(name = "expired")
    private Date expired;

    /**
     * 登录方式
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 登录ip
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;
}
