package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.KV;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 设备影像
 *
 * @Author changjiang
 * @Date 2023/5/28 since beijing
 */
@Data
public class DeviceShadowDTO implements Serializable {

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备影像时间
     */
    private Date time;

    /**
     * 指标
     */
    private List<KV> metrics;
}
