package com.changjiang.monitor.device;

import com.changjiang.monitor.dto.device.DeviceShadowDTO;

import java.util.List;

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
     * @param deviceId 设备id
     * @return 设备影像
     */
    DeviceShadowDTO currentShadow(String deviceId);

    /**
     * 获取设备影像集合
     *
     * @param deviceId 设备id
     * @param time     距今时间
     * @return 设备影像集合
     */
    List<DeviceShadowDTO> getShadowList(String deviceId, int time);

    /**
     * 获取设备影像集合
     *
     * @param deviceId 设备id
     * @param begin    开始时间
     * @param end      结束时间
     * @return 设备影像集合
     */
    List<DeviceShadowDTO> getShadowList(String deviceId, String begin, String end);
}
