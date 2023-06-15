package com.changjiang.monitor.device.wrapper;

import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.device.DeviceDTO;
import com.changjiang.monitor.entity.Device;
import lombok.NonNull;
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

        return null;
    }

    @Override
    public Device convertTE(@NonNull DeviceDTO deviceDTO) {
        return null;
    }
}
