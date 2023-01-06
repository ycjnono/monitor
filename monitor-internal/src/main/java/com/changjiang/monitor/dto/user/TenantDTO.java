package com.changjiang.monitor.dto.user;

import com.changjiang.monitor.dto.status.TenantStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
public class TenantDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 租户名称
     */
    private String name;

    /**
     * 账号域
     */
    private String domain;

    /**
     * 备注
     */
    private String remark;

    /**
     * 租户状态
     */
    private TenantStatus status;

    /**
     * 管理员手机号
     */
    private String managePhoneNumber;

    /**
     * 管理员邮箱
     */
    private String manageEmail;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiredTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
