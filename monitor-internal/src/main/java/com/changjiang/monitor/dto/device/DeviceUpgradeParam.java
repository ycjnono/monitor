package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备升级参数
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class DeviceUpgradeParam implements Serializable {

    /**
     * 升级时间指令
     * <p>
     * 1 = now 立刻
     * 2 = leisure 闲时
     * 3 = pre shutdown 关机前
     * 4 = custom 自定义时间
     */
    private int upTimeStatus;

    /**
     * 自定义升级时间
     */
    private Date upCustomTime;
}
