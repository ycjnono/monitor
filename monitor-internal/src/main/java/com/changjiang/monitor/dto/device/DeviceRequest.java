package com.changjiang.monitor.dto.device;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 设备请求参数
 *
 * @Author changjiang
 * @Date 2023/5/20 since beijing
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class DeviceRequest extends DeviceDTO{

    private Integer pageNo;

    private Integer pageSize;

    private Integer order;
}
