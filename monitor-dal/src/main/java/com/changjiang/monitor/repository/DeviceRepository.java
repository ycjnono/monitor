package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 设备实体操作
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, String>, JpaSpecificationExecutor<Device> {
}
