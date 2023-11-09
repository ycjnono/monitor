package com.changjiang.monitor.device.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.changjiang.monitor.SearchConditionService;
import com.changjiang.monitor.base.KV;
import com.changjiang.monitor.device.IDeviceSpecsService;
import com.changjiang.monitor.device.wrapper.DeviceSpecsWrapper;
import com.changjiang.monitor.dto.device.DeviceSpecsDTO;
import com.changjiang.monitor.dto.device.DeviceSpecsRequest;
import com.changjiang.monitor.dto.status.Status;
import com.changjiang.monitor.entity.DeviceSpecs;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.DeviceSpecsRepository;
import com.changjiang.monitor.result.CodeEnum;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备规格服务接口实现
 *
 * @Author changjiang
 * @Date 2023/9/21 since beijing
 */
@Service
public class DeviceSpecsServiceImpl implements IDeviceSpecsService,
        SearchConditionService<DeviceSpecs, DeviceSpecsRequest> {

    @Resource
    private DeviceSpecsRepository repository;

    @Resource
    private DeviceSpecsWrapper wrapper;


    @Override
    public DeviceSpecsDTO save(DeviceSpecsRequest request) {
        // check param
        if (StringUtils.isAnyBlank(request.getTenantId(), request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        DeviceSpecs specs = wrapper.convertTE(request);
        specs = repository.saveAndFlush(specs);
        return wrapper.convertET(specs);
    }

    @Override
    public DeviceSpecsDTO update(DeviceSpecsRequest request) {
        // check param
        if (request == null || StringUtils.isAnyBlank(request.getTenantId(), request.getId(), request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        DeviceSpecs specs = wrapper.convertTE(request);
        specs = repository.saveAndFlush(specs);
        return wrapper.convertET(specs);
    }

    @Override
    public List<DeviceSpecsDTO> list(String tenantId) {
        if (StringUtils.isBlank(tenantId)){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        DeviceSpecsRequest request =  new DeviceSpecsRequest();
        request.setTenantId(tenantId);
        return list(request);
    }

    @Override
    public List<DeviceSpecsDTO> list(DeviceSpecsRequest request) {
        if (request == null){
            return new ArrayList<>();
        }
        // create condition
        Specification<DeviceSpecs> conditions = createConditions(request);
        List<DeviceSpecs> deviceSpecs = repository.findAll(conditions);
        if (CollectionUtil.isNotEmpty(deviceSpecs)){
            return deviceSpecs.stream().map(specs -> wrapper.convertET(specs)).toList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<KV> listSimple(String tenantId) {
        return null;
    }

    @Override
    public DeviceSpecsDTO findById(String specsId) {
        return null;
    }

    @Override
    public Specification<DeviceSpecs> createConditions(DeviceSpecsRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> condition = new ArrayList<>();
            String name = request.getName();
            if (StringUtils.isNotBlank(name)) {
                condition.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            Status status = request.getStatus();
            if (status != null) {
                condition.add(criteriaBuilder.equal(root.get("status"), status.name()));
            }
            String specsId = request.getTenantId();
            if (StringUtils.isNotBlank(specsId)) {
                condition.add(criteriaBuilder.equal(root.get("tenantId"), specsId));
            }
            if (CollectionUtil.isEmpty(condition)) {
                return null;
            }
            Predicate[] predicates = condition.toArray(Predicate[]::new);
            return query.where(predicates).getRestriction();
        };
    }
}
