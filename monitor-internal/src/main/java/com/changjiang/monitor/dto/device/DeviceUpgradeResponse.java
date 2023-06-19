package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 设备升级结果
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class DeviceUpgradeResponse implements Serializable {

    /**
     * 指令下发是否成功
     */
    private boolean success;

    /**
     * 当前版本号
     */
    private String currentVersion;

    /**
     * 其他参数
     */
    private Map<String, Object> feature;
}
