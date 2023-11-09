package com.changjiang.monitor.dto.device;

import com.changjiang.monitor.base.BaseDTO;
import com.changjiang.monitor.dto.status.DeviceStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备通用dto
 *
 * @Author changjiang
 * @Date 2023/5/20 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceDTO extends BaseDTO {

    /**
     * 区域id
     */
    private String regionId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 规格id
     */
    private String specsId;

    /**
     * 设备状态
     */
    private DeviceStatus status;

    /**
     * 设备类型
     */
    private DeviceType type;

    /**
     * 设备子类型
     */
    private String subType;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 地址
     */
    private String address;

    /**
     * 设备ip
     */
    private String ip;

    /**
     * 详细配置
     */
    private DeviceConfigDTO config;

    /**
     * 制造商
     */
    private String manufacturer;

    /**
     * 连接信息
     */
    private String connectConfig;
}
