package com.changjiang.monitor.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租户状态
 *
 * @Author changjiang
 * @Date 2022/12/11 21:47 since beijing
 */
@Getter
@AllArgsConstructor
public enum TenantStatus {

    /**
     * 未激活
     */
    UnActive,

    /**
     * 正常
     */
    Normal,

    /**
     * 过期
     */
    Expired,

    /**
     * 锁定
     */
    Locked
}
