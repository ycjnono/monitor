package com.changjiang.monitor.region.impl;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.region.IRegionService;
import com.changjiang.monitor.repository.RegionRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.PageResult;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 区域服务接口实现
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Service
public class RegionServiceImpl implements IRegionService {

    @Resource
    private RegionRepository repository;

    @Override
    public RegionDTO save(RegionRequest request) {
        // 参数校验
        if (request == null || StringUtils.isAnyBlank(request.getName(), request.getTenantId())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }

        return null;
    }

    @Override
    public PageResult<RegionDTO> page(RegionRequest request) {
        return null;
    }
}
