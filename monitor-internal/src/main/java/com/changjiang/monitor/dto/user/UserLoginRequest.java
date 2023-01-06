package com.changjiang.monitor.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录参数
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String password;
}
