package com.changjiang.monitor.device.impl;

import com.changjiang.monitor.device.IDeviceRemoteService;
import com.changjiang.monitor.dto.device.DeviceRemoteOperationRequest;
import com.changjiang.monitor.dto.device.DeviceRemoteOperationResponse;
import com.changjiang.monitor.dto.device.DeviceUpgradeRequest;
import com.changjiang.monitor.dto.device.DeviceUpgradeResponse;
import org.springframework.stereotype.Service;

/**
 * 设备远程控制接口服务实现
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Service
public class DeviceRemoteServiceImpl implements IDeviceRemoteService {


    @Override
    public DeviceUpgradeResponse upgrade(DeviceUpgradeRequest request) {
        return null;
    }

    @Override
    public DeviceRemoteOperationResponse operation(DeviceRemoteOperationRequest request) {
        return null;
    }
}
