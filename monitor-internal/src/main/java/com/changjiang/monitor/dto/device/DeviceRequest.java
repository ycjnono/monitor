package com.changjiang.monitor.dto.device;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备请求参数
 *
 * @Author changjiang
 * @Date 2023/5/20 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceRequest extends DeviceDTO{

    private Integer pageNo;

    private Integer pageSize;
}
