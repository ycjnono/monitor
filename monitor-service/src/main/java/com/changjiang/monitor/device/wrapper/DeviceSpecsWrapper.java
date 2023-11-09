package com.changjiang.monitor.device.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.device.DeviceSpecsConfig;
import com.changjiang.monitor.dto.device.DeviceSpecsDTO;
import com.changjiang.monitor.dto.status.Status;
import com.changjiang.monitor.entity.DeviceSpecs;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 包装工具
 *
 * @Author changjiang
 * @Date 2023/9/21 since beijing
 */
@Service
public class DeviceSpecsWrapper implements ObjectConvert<DeviceSpecsDTO, DeviceSpecs> {

    @Override
    public DeviceSpecsDTO convertET(@NonNull DeviceSpecs deviceSpecs) {
        DeviceSpecsDTO dto = new DeviceSpecsDTO();
        BeanUtil.copyProperties(deviceSpecs, dto, "status", "config");
        String config = deviceSpecs.getConfig();
        if (StringUtils.isNotBlank(config)){
            dto.setConfig(JSON.parseObject(config, DeviceSpecsConfig.class));
        }
        String status = deviceSpecs.getStatus();
        if (StringUtils.isNotBlank(status)){
            dto.setStatus(Status.valueOf(status));
        }
        return dto;
    }

    @Override
    public DeviceSpecs convertTE(@NonNull DeviceSpecsDTO dto) {
        DeviceSpecs specs = new DeviceSpecs();
        BeanUtil.copyProperties(dto, specs, "status", "config");
        Status status = dto.getStatus();
        if (status != null){
            specs.setStatus(status.name());
        }
        DeviceSpecsConfig config = dto.getConfig();
        if (config != null){
            specs.setConfig(JSON.toJSONString(config));
        }
        return specs;
    }
}
