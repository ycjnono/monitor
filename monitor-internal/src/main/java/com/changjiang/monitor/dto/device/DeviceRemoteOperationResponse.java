package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 设备远程操作结果
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class DeviceRemoteOperationResponse implements Serializable {

    /**
     * 指令下发结果
     */
    private boolean success;

    /**
     * 其他参数
     */
    private Map<String, Object> feature;
}
