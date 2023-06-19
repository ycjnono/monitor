package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 设备升级请求参数
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class DeviceUpgradeRequest implements Serializable {

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 升级版本, 可指定旧版本==回退
     */
    private String upVersion;

    /**
     * 升级固定参数
     */
    private DeviceUpgradeParam param;

    /**
     * 升级其他参数
     */
    private Map<String, Object> feature;
}
