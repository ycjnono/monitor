package com.changjiang.monitor.dto.user;

import com.changjiang.monitor.base.BaseDTO;
import com.changjiang.monitor.dto.status.UserStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户登录信息
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAuthDTO extends BaseDTO {

    /**
     * 用户名
     */
    private String name;

    /**
     * 角色
     */
    private String role;

    /**
     * 头像
     */
    private String header;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户状态
     */
    private UserStatus status;

    /**
     * 登录token
     */
    private String token;

    /**
     * token过期时间
     */
    private Date expired;

    /**
     * 手机号
     */
    private String phoneNumber;
}
