package com.changjiang.monitor.device;

import com.changjiang.monitor.entity.MonitorDevice;

import java.util.Date;
import java.util.List;

/**
 * 设备监控操作服务接口
 *
 * @Author changjiang
 * @Date 2023/6/16
 */
public interface IDeviceOperationService {

    /**
     * 获取所有符合调度条件的监控设备
     *
     * @param regionId 区域id
     * @return 服务调度条件的监控设备
     */
    List<MonitorDevice> getAllScheduleDevice(String regionId);

    /**
     * 关闭监控
     *
     * @param deviceId 设备id
     * @param autoOpen 后续是否自动开启
     * @return 操作结果
     */
    boolean closeMonitor(String deviceId, boolean autoOpen);

    /**
     * 关闭监控
     *
     * @param deviceId     设备id
     * @param nextOpenTime 下次开启时间
     * @return 操作结果
     */
    boolean closeMonitor(String deviceId, Date nextOpenTime);


    /**
     * 开启监控, 从未开启的,默认注册并开启监控
     *
     * @param deviceId 设备id
     * @return 操作结果
     */
    boolean openMonitor(String deviceId);


    /**
     * 开始监控
     *
     * @param deviceId      设备id
     * @param nextCloseTime 下次关闭时间
     * @return 操作结果
     */
    boolean openMonitor(String deviceId, Date nextCloseTime);


}
