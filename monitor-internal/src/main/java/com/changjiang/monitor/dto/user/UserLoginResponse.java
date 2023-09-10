package com.changjiang.monitor.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录返回
 *
 * @Author changjiang
 * @Date 2023/4/20 since beijing
 */
@Data
public class UserLoginResponse implements Serializable {

    /**
     * token
     */
    private String token;

    /**
     * 登录信息
     */
    private UserAuthDTO user;
}
