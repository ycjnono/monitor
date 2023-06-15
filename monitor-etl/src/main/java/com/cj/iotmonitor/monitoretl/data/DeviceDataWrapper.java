package com.cj.iotmonitor.monitoretl.data;

import com.changjiang.monitor.dto.device.DeviceShadowDTO;
import org.springframework.stereotype.Component;

/**
 * 设备数据包装工具
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Component
public class DeviceDataWrapper {

    /**
     * 生成最新的设备影像
     *
     * @param deviceShadow
     * @return
     */
    public DeviceShadowDTO buildShadow(DeviceShadowDTO deviceShadow){
        throw new UnsupportedOperationException();
    }
}
