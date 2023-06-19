package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.MonitorRegion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 监控区域持久化服务接口
 *
 * @Author changjiang
 * @Date 2023/6/19
 */
public interface MonitorRegionRepository extends JpaRepository<MonitorRegion, String> {

    /**
     * 获取指定状态的region集合
     *
     * @param status 状态
     * @return region集合
     */
    List<MonitorRegion> getAllByStatus(String status);
}
