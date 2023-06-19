package com.changjiang.monitor.region;

import com.changjiang.monitor.dto.region.MonitorRegionDTO;
import com.changjiang.monitor.entity.MonitorRegion;

import java.util.List;

/**
 * 区域监控操作服务接口
 *
 * @Author changjiang
 * @Date 2023/6/16
 */
public interface IRegionOperationService {

    /**
     * 获取所有符合调度的区域
     *
     * @return 监控区域集合
     */
    List<MonitorRegionDTO> getAllScheduleRegion();

    /**
     * 关闭该区域下所有设备监控
     *
     * @param regionId   区域id
     * @param autoOpen   后续是否自动开启
     * @param sendReport 是否发送报告
     * @return 操作结果
     */
    boolean closeMonitor(String regionId, boolean autoOpen, boolean sendReport);

    /**
     * 开启该区域下所有设备监控, 独立监控的设备除外
     *
     * @param regionId   区域id
     * @param autoClose  后续是否自动关闭
     * @param sendReport 是否发送报告
     * @return 操作结果
     */
    boolean openMonitor(String regionId, boolean autoClose, boolean sendReport);

}
