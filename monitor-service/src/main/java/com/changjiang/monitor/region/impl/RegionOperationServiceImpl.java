package com.changjiang.monitor.region.impl;

import com.changjiang.monitor.dto.region.MonitorRegionDTO;
import com.changjiang.monitor.region.IRegionOperationService;
import com.changjiang.monitor.repository.MonitorRegionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监控区域操作服务接口实现
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Service
public class RegionOperationServiceImpl implements IRegionOperationService {

    @Resource
    private MonitorRegionRepository repository;

    @Override
    public List<MonitorRegionDTO> getAllScheduleRegion() {

        return null;
    }

    @Override
    public boolean closeMonitor(String regionId, boolean autoOpen, boolean sendReport) {
        return false;
    }

    @Override
    public boolean openMonitor(String regionId, boolean autoClose, boolean sendReport) {
        return false;
    }
}
