package com.changjiang.monitor.user;

import com.changjiang.monitor.dto.user.TenantDTO;
import com.changjiang.monitor.dto.user.TenantRequest;
import com.changjiang.monitor.result.PageResult;

import java.util.List;

/**
 * 租户服务接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface ITenantService {

    /**
     * 保存
     *
     * @param request 请求参数
     * @return
     */
    TenantDTO save(TenantRequest request);

    /**
     * 修改
     *
     * @param request 请求参数
     * @return
     */
    TenantDTO update(TenantRequest request);

    /**
     * 根据id查找
     *
     * @param tenantId 租户id
     * @return
     */
    TenantDTO findById(String tenantId);

    /**
     * 根据id删除
     *
     * @param tenantId 租户id
     * @return
     */
    Boolean deleteById(String tenantId);

    /**
     * 分页检索
     *
     * @param request 请求参数
     * @return
     */
    PageResult<TenantDTO> page(TenantRequest request);

    /**
     * 列表检索
     *
     * @param request 请求参数
     * @return
     */
    List<TenantDTO> findAll(TenantRequest request);
}
