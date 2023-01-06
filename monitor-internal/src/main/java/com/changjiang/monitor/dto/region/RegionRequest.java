package com.changjiang.monitor.dto.region;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区域请求参数
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RegionRequest extends RegionDTO{

    private Integer pageNo;

    private Integer pageSize;
}
