package com.changjiang.monitor.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 报告类型
 *
 * @Author changjiang
 * @Date 2023/6/16 17:32 since beijing
 */
@Getter
@AllArgsConstructor
public enum MonitorReportType {

    DeviceCheckSelf,
    RegionDeviceStatus,
    RegionOperation
}
