package com.cj.iotmonitor.monitoretl.api;

import com.cj.iotmonitor.monitoretl.service.DeviceShadowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 设备影像接口
 *
 * @Author changjiang
 * @Date 2023/5/28 since beijing
 */
@RestController
@RequestMapping("/api/device/shadow")
public class DeviceShadowController {

    @Resource
    private DeviceShadowService service;

    /**
     * 获取实时设备影像
     *
     * @param deviceId 设备id
     * @return
     */
    @GetMapping("/{deviceId}")
    public Object getDeviceShadow(@PathVariable String deviceId) {
        return service.getDeviceShadow(deviceId);
    }

    /**
     * 获取多长时间之内的设备影像集合
     *
     * @param deviceId 设备id
     * @param time     与当前时间差, min
     * @return
     */
    @GetMapping("/{deviceId}/time")
    public Object getDeviceShadows(@PathVariable String deviceId, @RequestParam Integer time) {
        return service.getDeviceShadows(deviceId, time);
    }


    /**
     * 获取设备影像
     * <p>
     * This method is used to get the device shadows for a particular device within a specified time range.
     *
     * @param deviceId The ID of the device whose shadows are to be retrieved.
     * @param begin    The beginning of the time range for which shadows are to be retrieved.
     * @param end      The end of the time range for which shadows are to be retrieved.
     * @return An object representing the device shadows.
     */
    @GetMapping("/{deviceId}/timeRange")
    public Object getDeviceShadows(@PathVariable String deviceId, @RequestParam String begin,
                                   @RequestParam String end) {
        return service.getDeviceShadows(deviceId, begin, end);
    }

}
