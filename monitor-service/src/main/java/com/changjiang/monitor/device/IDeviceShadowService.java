package com.changjiang.monitor.device;

import com.changjiang.monitor.dto.device.DeviceShadowDTO;

/**
 * 设备影像服务接口
 *
 * @Author changjiang
 * @Date 2023/6/16
 */
public interface IDeviceShadowService {

    /**
     * 根据设备id获取当前设备影像
     *
     * @param deviceId  设备id
     * @return  设备影像
     */
    DeviceShadowDTO currentShadow(String deviceId);
}
