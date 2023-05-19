package com.changjiang.monitor.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This code snippet shows the declaration of a Java enumeration named "RegionStatus".
 * An enumeration is a special data type that allows developers to define a fixed set of constants that can be used as values in their programs.
 * In this case, the "RegionStatus" enumeration is designed to represent the different statuses or states of a region or area. The exact constants included in the enumeration will depend on the specific needs of the program using it,
 * but examples could include "active", "inactive", "under construction", "closed", "restricted access", etc. By using an enumeration, developers can ensure that only valid status values are used in their code,
 * which can improve program reliability and reduce errors.
 *
 * @Author changjiang
 * @Date 2023/5/18 21:29 since beijing
 */
@Getter
@AllArgsConstructor
public enum RegionStatus {

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
