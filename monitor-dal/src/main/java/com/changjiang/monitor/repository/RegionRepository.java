package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 区域实体操作
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
}
