package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.DeviceSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 设备规格
 *
 * @Author changjiang
 * @Date 2023/11/9
 */
@Repository
public interface DeviceSpecsRepository extends JpaRepository<DeviceSpecs, String>, JpaSpecificationExecutor<DeviceSpecs> {
}
