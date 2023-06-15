package com.changjiang.monitor.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 设备状态
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Getter
@AllArgsConstructor
public enum DeviceStatus {

    /**
     * 正常在线
     */
    Online,
    /**
     * 离线
     */
    Offline,
    /**
     * 警告中
     */
    Warning,
    /**
     * 损坏
     */
    Bad,
    ;
}
