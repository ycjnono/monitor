package com.changjiang.monitor.device;

import com.changjiang.monitor.dto.device.DeviceRemoteOperationRequest;
import com.changjiang.monitor.dto.device.DeviceRemoteOperationResponse;
import com.changjiang.monitor.dto.device.DeviceUpgradeRequest;
import com.changjiang.monitor.dto.device.DeviceUpgradeResponse;

/**
 * 设备远程操作服务接口
 *
 * @Author changjiang
 * @Date 2023/6/16
 */
public interface IDeviceRemoteService {

    /**
     * 设备升级
     *
     * @param request   请求参数
     * @return  升级结果
     */
    DeviceUpgradeResponse upgrade(DeviceUpgradeRequest request);

    /**
     * 远程操作
     *
     * @param request   请求参数
     * @return  操作结果
     */
    DeviceRemoteOperationResponse operation(DeviceRemoteOperationRequest request);
}
