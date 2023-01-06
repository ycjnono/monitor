package com.changjiang.monitor.dto.user;

import com.changjiang.monitor.base.BaseDTO;
import com.changjiang.monitor.dto.status.UserStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 基础角色
     */
    private String role;

    /**
     * 头像
     */
    private String header;

    /**
     * 用户状态
     */
    private UserStatus status;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 过期时间
     */
    private Date expiredTime;
}
