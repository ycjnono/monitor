package com.changjiang.monitor.region;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.result.PageResult;

/**
 * 区域服务接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface IRegionService {

    /**
     * 保存区域
     *
     * @param request 请求参数
     * @return
     */
    RegionDTO save(RegionRequest request);

    /**
     * 分页检索
     *
     * @param request
     * @return
     */
    PageResult<RegionDTO> page(RegionRequest request);
}
