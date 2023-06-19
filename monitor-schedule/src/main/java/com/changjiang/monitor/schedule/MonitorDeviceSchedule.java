package com.changjiang.monitor.schedule;

import com.changjiang.monitor.device.IDeviceOperationService;
import com.changjiang.monitor.region.IRegionOperationService;
import jakarta.annotation.Resource;

/**
 * 监控设备调度
 * <p>
 *     设备需处于待调度状态,同时符合以下条件
 *     1. region处于监控状态下的监控设备
 *     2. region处于非监控状态但设备本身属于单独调度的监控设备
 * </p>
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
public class MonitorDeviceSchedule {

    /**
     * 监控设备调度key
     */
    private final static String  MonitorDeviceScheduleKey = "_Device_Schedule_Key_";

    @Resource
    private IDeviceOperationService deviceOperationService;

    @Resource
    private IRegionOperationService regionOperationService;

    /**
     * 调度
     */
    public void schedule(){
        // 获取监控状态下的region集合

    }
}
