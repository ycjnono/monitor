package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.MonitorDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 监控设备持久层操作接口
 *
 * @Author changjiang
 * @Date 2023/6/19
 */
@Repository
public interface MonitorDeviceRepository extends JpaRepository<MonitorDevice, String> {

    /**
     * 根据regionId获取所有监控设备
     *
     * @param regionId 区域id
     * @return 监控设备集合
     */
    List<MonitorDevice> getAllByRegionId(String regionId);

    /**
     * 根据regionId获取所有监控设备
     *
     * @param regionId  区域id
     * @param status    状态
     * @return  监控设备集合
     */
    List<MonitorDevice> getAllByRegionIdAndStatus(String regionId, String status);
}
