package com.cj.iotmonitor.monitoretl.service;

import com.changjiang.monitor.dto.device.DeviceShadowDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备影像服务
 *
 * @Author changjiang
 * @Date 2023/5/28 since beijing
 */
@Service
public class DeviceShadowService {

    /**
     * 获取设备影像
     *
     * @param deviceId 设备id
     * @param time     时间间隔,分钟
     * @return
     */
    public List<DeviceShadowDTO> getDeviceShadows(String deviceId, int time) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取设备影像
     *
     * @param deviceId  设备id
     * @param begin     开始时间
     * @param end       结束时间
     * @return
     */
    public List<DeviceShadowDTO> getDeviceShadows(String deviceId, String begin, String end){
        throw new UnsupportedOperationException();
    }

    /**
     * 获取设备影像
     *
     * @param deviceId
     * @return
     */
    public DeviceShadowDTO getDeviceShadow(String deviceId){
        throw new UnsupportedOperationException();
    }

    /**
     * 保存设备影像
     *
     * @param deviceShadow
     */
    public void saveDeviceShadow(DeviceShadowDTO deviceShadow){
        throw new UnsupportedOperationException();
    }
}
