package com.changjiang.monitor.dto.device;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 设备类型
 *
 * @Author changjiang
 * @Date 2023/5/20 14:00 since beijing
 */
@Getter
@AllArgsConstructor
public enum DeviceType {

    /**
     * 拍摄设备,相机\摄像头\智能相机
     */
    Camera,
    /**
     * 传感器,温湿度\空气质量等
     */
    Sensor,
    /**
     * 流类型,
     */
    Stream,
    /**
     * 虚拟设备
     */
    Absent,
    /**
     * 服务器/主机
     */
    Server,
    ;

}
