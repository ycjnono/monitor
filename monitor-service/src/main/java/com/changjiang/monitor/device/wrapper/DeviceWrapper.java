package com.changjiang.monitor.device.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.device.DeviceConfigDTO;
import com.changjiang.monitor.dto.device.DeviceDTO;
import com.changjiang.monitor.dto.device.DeviceType;
import com.changjiang.monitor.dto.status.DeviceStatus;
import com.changjiang.monitor.entity.Device;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 设备包装工具类
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Component
public class DeviceWrapper implements ObjectConvert<DeviceDTO, Device> {


    @Override
    public DeviceDTO convertET(@NonNull Device device) {
        DeviceDTO dto  = new DeviceDTO();
        BeanUtil.copyProperties(device, dto, "status", "type", "config");
        String status = device.getStatus();
        if (StringUtils.isNotBlank(status)){
            dto.setStatus(DeviceStatus.valueOf(status));
        }
        String type = device.getType();
        if (StringUtils.isNotBlank(type)){
            dto.setType(DeviceType.valueOf(type));
        }
        String config = device.getConfig();
        if (StringUtils.isNotBlank(config)){
            dto.setConfig(JSON.parseObject(config, DeviceConfigDTO.class));
        }
        return dto;
    }

    @Override
    public Device convertTE(@NonNull DeviceDTO deviceDTO) {
        Device device = new Device();
        BeanUtil.copyProperties(deviceDTO, device, "status", "type", "config");
        DeviceStatus status = deviceDTO.getStatus();
        if (status != null){
            device.setStatus(status.name());
        }
        DeviceType type = deviceDTO.getType();
        if (type != null){
            device.setType(type.name());
        }
        DeviceConfigDTO config = deviceDTO.getConfig();
        if (config != null){
            device.setConfig(JSON.toJSONString(config));
        }
        return device;
    }
}
