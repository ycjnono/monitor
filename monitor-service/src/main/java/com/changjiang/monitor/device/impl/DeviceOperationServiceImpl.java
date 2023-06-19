package com.changjiang.monitor.device.impl;

import com.changjiang.monitor.device.IDeviceOperationService;
import com.changjiang.monitor.entity.MonitorDevice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设备监控操作服务接口
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Service
public class DeviceOperationServiceImpl implements IDeviceOperationService {


    @Override
    public List<MonitorDevice> getAllScheduleDevice(String regionId) {
        return new ArrayList<>();
    }

    @Override
    public boolean closeMonitor(String deviceId, boolean autoOpen) {
        return false;
    }

    @Override
    public boolean closeMonitor(String deviceId, Date nextOpenTime) {
        return false;
    }

    @Override
    public boolean openMonitor(String deviceId) {
        return false;
    }

    @Override
    public boolean openMonitor(String deviceId, Date nextCloseTime) {
        return false;
    }
}
