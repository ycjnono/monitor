package com.changjiang.monitor.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建用户参数
 *
 * @Author changjiang
 * @Date 2023/1/2 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreateUserRequest extends UserDTO {

    /**
     * 创建用户类型
     */
    private CreateUserType createUserType;

    /**
     * 密码
     */
    private String password;

}
