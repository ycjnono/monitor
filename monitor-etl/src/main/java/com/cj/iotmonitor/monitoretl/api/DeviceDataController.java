package com.cj.iotmonitor.monitoretl.api;

import com.changjiang.monitor.dto.device.DeviceShadowDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 原始数据相关接口
 *
 * @Author changjiang
 * @Date 2023/6/8 since beijing
 */
@RestController
@RequestMapping("/device/data")
public class DeviceDataController {

    /**
     * 设备日志上报
     *
     * @param deviceId      设备id
     * @param deviceShadow  设备影像数据
     * @return
     */
    @PostMapping("/{deviceId}/log")
    public Object log(@PathVariable String deviceId, @RequestBody DeviceShadowDTO deviceShadow){
        throw new UnsupportedOperationException();
    }
}
