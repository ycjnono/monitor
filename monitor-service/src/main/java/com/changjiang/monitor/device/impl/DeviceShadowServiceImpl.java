package com.changjiang.monitor.device.impl;

import com.changjiang.monitor.device.IDeviceShadowService;
import com.changjiang.monitor.dto.device.DeviceShadowDTO;
import org.springframework.stereotype.Service;

/**
 * 设备影像服务接口实现
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Service
public class DeviceShadowServiceImpl implements IDeviceShadowService {



    @Override
    public DeviceShadowDTO currentShadow(String deviceId) {
        return null;
    }
}
