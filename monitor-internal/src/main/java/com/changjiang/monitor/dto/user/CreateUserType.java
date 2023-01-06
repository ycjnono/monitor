package com.changjiang.monitor.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 创建用户类型
 *
 * @Author changjiang
 * @Date 2023/1/2 22:10 since beijing
 */
@Getter
@AllArgsConstructor
public enum CreateUserType {

    TenantInit,

    TenantManage,


}
