package com.changjiang.monitor.dto.device;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author changjiang
 * @Date 2023/9/21 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceSpecsRequest extends DeviceSpecsDTO{

    private Integer pageNo;

    private Integer pageSize;
}
