package com.changjiang.monitor.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户请求参数
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantRequest extends TenantDTO{

    /**
     * 分页参数
     */
    private Integer pageNo;

    /**
     * 分页参数
     */
    private Integer pageSize;
}
