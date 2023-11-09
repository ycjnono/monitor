package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.KV;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 设备详细配置
 *
 * @Author changjiang
 * @Date 2023/9/21 since beijing
 */
@Data
public class DeviceConfigDTO implements Serializable {

    private StreamConfig streamConfig;

    /**
     * 其他配置
     */
    private List<KV> extra;
}
