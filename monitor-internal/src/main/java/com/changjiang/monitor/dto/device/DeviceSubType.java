package com.changjiang.monitor.dto.device;

import lombok.AllArgsConstructor;

/**
 * 设备子类型
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@AllArgsConstructor
public enum DeviceSubType {

    Camera(DeviceType.Camera),
    Camera_Reid(DeviceType.Camera),

    Stream_Rtsp(DeviceType.Stream),
    Stream_Rtmp(DeviceType.Stream),

    Sensor_Temp(DeviceType.Sensor),
    Sensor_Radar(DeviceType.Sensor),

    File_M3u8(DeviceType.Absent),
    File_Video(DeviceType.Absent),

    Server_Win(DeviceType.Server),
    Server_Linux(DeviceType.Server),
    ;

    /**
     * 父类型
     */
    private final DeviceType parentType;

}
