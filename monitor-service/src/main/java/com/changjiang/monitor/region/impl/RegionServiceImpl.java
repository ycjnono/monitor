package com.changjiang.monitor.region.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.dto.region.RegionType;
import com.changjiang.monitor.dto.status.RegionStatus;
import com.changjiang.monitor.entity.Region;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.region.IRegionService;
import com.changjiang.monitor.repository.RegionRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.PageResult;
import com.changjiang.monitor.user.wrapper.RegionWrapper;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private RegionWrapper regionWrapper;

    @Override
    public RegionDTO save(RegionRequest request) {
        // 参数校验
        if (request == null || StringUtils.isAnyBlank(request.getName(), request.getTenantId())) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        Region region = regionWrapper.convertTE(request);
        region = repository.saveAndFlush(region);
        return regionWrapper.convertET(region);
    }

    @Override
    public RegionDTO update(RegionRequest request) {
        return null;
    }

    @Override
    public RegionDTO updateStatus(String id, String status) {
        return null;
    }

    @Override
    public PageResult<RegionDTO> page(RegionRequest request) {
        if (request == null) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }

        Sort orders = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), orders);
        Specification<Region> conditions = (root, query, criteriaBuilder) -> {
            List<Predicate> condition = new ArrayList<>();
            String name = request.getName();
            if (StringUtils.isNotBlank(name)) {
                condition.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            RegionStatus status = request.getStatus();
            if (status != null) {
                condition.add(criteriaBuilder.equal(root.get("status"), status.name()));
            }
            String tenantId = request.getTenantId();
            if (StringUtils.isNotBlank(tenantId)){
                condition.add(criteriaBuilder.equal(root.get("tenantId"), tenantId));
            }
            RegionType type = request.getType();
            if (type != null){
                condition.add(criteriaBuilder.equal(root.get("type"), type.name()));
            }
            if (CollectionUtil.isEmpty(condition)) {
                return null;
            }
            Predicate[] predicates = condition.toArray(Predicate[]::new);
            return query.where(predicates).getRestriction();
        };
        Page<Region> page = repository.findAll(conditions, pageRequest);
        List<Region> list = page.getContent();
        if (CollectionUtil.isEmpty(list)) {
            return PageResult.of(new ArrayList<>(), page.getTotalElements(), request.getPageNo(), request.getPageSize());
        }
        List<RegionDTO> dtoList = list.stream().map(region -> regionWrapper.convertET(region)).toList();
        return PageResult.of(dtoList, page.getTotalElements(), request.getPageNo(), request.getPageSize());
    }
}
