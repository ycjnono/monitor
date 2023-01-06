package com.changjiang.monitor.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 *
 * @Author changjiang
 * @Date 2023/1/7 2:33 since beijing
 */
@Getter
@AllArgsConstructor
public enum UserStatus {

    Normal,
    Expired,
    Locked
}
