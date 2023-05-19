package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 租户操作
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, String>, JpaSpecificationExecutor<Tenant> {

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    Tenant findByName(String name);


}
