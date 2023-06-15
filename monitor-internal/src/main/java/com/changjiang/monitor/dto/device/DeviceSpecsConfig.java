package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.KV;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 设备规格详细配置
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Data
public class DeviceSpecsConfig implements Serializable {

    /**
     * 配置列表
     */
    private List<KV> configs;
}
