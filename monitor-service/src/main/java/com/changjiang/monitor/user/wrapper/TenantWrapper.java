package com.changjiang.monitor.user.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.status.TenantStatus;
import com.changjiang.monitor.dto.user.TenantDTO;
import com.changjiang.monitor.entity.Tenant;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * 租户包装工具类
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Component
public class TenantWrapper implements ObjectConvert<TenantDTO, Tenant> {

    @Override
    public TenantDTO convertET(@NotNull Tenant tenant) {
        TenantDTO tenantDTO = new TenantDTO();
        BeanUtil.copyProperties(tenant, tenantDTO, "status");
        if (StringUtils.isNotBlank(tenant.getStatus())){
            tenantDTO.setStatus(TenantStatus.valueOf(tenant.getStatus()));
        }
        return tenantDTO;
    }

    @Override
    public Tenant convertTE(@NotNull TenantDTO tenantDTO) {
        Tenant tenant = new Tenant();
        BeanUtil.copyProperties(tenantDTO, tenant, "status");
        if (tenantDTO.getStatus() != null){
            tenant.setStatus(tenantDTO.getStatus().name());
        }
        return tenant;
    }
}
