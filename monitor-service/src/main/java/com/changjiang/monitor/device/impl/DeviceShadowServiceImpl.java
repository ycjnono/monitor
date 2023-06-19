package com.changjiang.monitor.device.impl;

import com.changjiang.monitor.device.IDeviceShadowService;
import com.changjiang.monitor.dto.device.DeviceShadowDTO;
import com.changjiang.monitor.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 设备影像服务接口实现
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Service
public class DeviceShadowServiceImpl implements IDeviceShadowService {

    @Value("${system.monitor.data.etl.host}")
    private String ApiHot;

    private static final String GetShadowPath = "/api/device/shadow/{deviceId}";
    private static final String GetShadowListPath = "/api/device/shadow/{deviceId}/time";
    private static final String GetShadowTimeRangeListPath = "/api/device/shadow/{deviceId}/timeRange";

    @Override
    public DeviceShadowDTO currentShadow(String deviceId) {
        String apiUrl = ApiHot + GetShadowPath.replace("{deviceId}", deviceId);
        Optional<DeviceShadowDTO> optional = HttpUtil.get(apiUrl, null, DeviceShadowDTO.class);
        return optional.orElse(null);
    }

    @Override
    public List<DeviceShadowDTO> getShadowList(String deviceId, int time) {
        String apiUrl = ApiHot + GetShadowListPath.replace("{deviceId}", deviceId);
        Optional<List<DeviceShadowDTO>> optional = HttpUtil.getList(apiUrl, null, DeviceShadowDTO.class);
        return optional.orElse(new ArrayList<>());
    }

    @Override
    public List<DeviceShadowDTO> getShadowList(String deviceId, String begin, String end) {
        String apiUrl = ApiHot + GetShadowTimeRangeListPath.replace("{deviceId}", deviceId);
        Map<String, String> params = new HashMap<>();
        params.put("begin", begin);
        params.put("end", end);
        Optional<List<DeviceShadowDTO>> optional = HttpUtil.getList(apiUrl, params, DeviceShadowDTO.class);
        return optional.orElse(new ArrayList<>());
    }
}
