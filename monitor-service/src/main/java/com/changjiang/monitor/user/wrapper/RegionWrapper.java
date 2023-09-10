package com.changjiang.monitor.user.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionType;
import com.changjiang.monitor.dto.status.RegionStatus;
import com.changjiang.monitor.entity.Region;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @Author changjiang
 * @Date 2023/9/11 since beijing
 */
@Component
public class RegionWrapper implements ObjectConvert<RegionDTO, Region> {

    @Override
    public RegionDTO convertET(@NonNull Region region) {
        RegionDTO dto = new RegionDTO();
        BeanUtil.copyProperties(region, dto, "status", "type");
        String status = region.getStatus();
        if (StringUtils.isNotBlank(status)){
            dto.setStatus(RegionStatus.valueOf(status));
        }
        String type = region.getType();
        if (StringUtils.isNotBlank(type)){
            dto.setType(RegionType.valueOf(type));
        }
        return dto;
    }

    @Override
    public Region convertTE(@NonNull RegionDTO regionDTO) {
        Region region = new Region();
        BeanUtil.copyProperties(regionDTO, region, "status", "type");
        RegionStatus status = regionDTO.getStatus();
        if (status != null){
            region.setStatus(status.name());
        }
        RegionType type = regionDTO.getType();
        if (type != null){
            region.setType(type.name());
        }
        return region;
    }
}
