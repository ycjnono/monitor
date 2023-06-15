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
 * 系统用户表
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@Entity
@Table(name = "user")
@EqualsAndHashCode(callSuper = true)
@Where(clause = "`deleted` = false")
@SQLDelete(sql = "update `user` set `deleted` = true where id = ?")
public class User extends BaseEntity{

    /**
     * 租户id
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    @Column(name = "header")
    private String header;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

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
