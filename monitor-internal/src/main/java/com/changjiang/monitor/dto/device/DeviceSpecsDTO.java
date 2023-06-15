package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备规格
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceSpecsDTO extends BaseDTO {

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格说明
     */
    private String remark;

    /**
     * 监控规格id
     */
    private String monitorRuleId;

    /**
     * 详细配置
     */
    private DeviceSpecsConfig config;
}
