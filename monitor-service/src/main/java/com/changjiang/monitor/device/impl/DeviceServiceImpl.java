package com.changjiang.monitor.device.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.changjiang.monitor.device.IDeviceService;
import com.changjiang.monitor.device.wrapper.DeviceWrapper;
import com.changjiang.monitor.dto.device.DeviceDTO;
import com.changjiang.monitor.dto.device.DeviceRequest;
import com.changjiang.monitor.dto.status.DeviceStatus;
import com.changjiang.monitor.entity.Device;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.DeviceRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.PageResult;
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
import java.util.Optional;

/**
 * 设备服务接口实现
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Resource
    private DeviceRepository repository;

    @Resource
    private DeviceWrapper deviceWrapper;

    @Override
    public DeviceDTO save(DeviceRequest request) {
        // check param
        if (StringUtils.isAnyBlank(request.getTenantId(), request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // convert
        Device device = deviceWrapper.convertTE(request);
        // save
        device = repository.saveAndFlush(device);
        // convert
        return deviceWrapper.convertET(device);
    }

    @Override
    public DeviceDTO findById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        Optional<Device> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new MonitorException(CodeEnum.IllegalArgumentNotFind);
        }
        return deviceWrapper.convertET(optional.get());
    }

    @Override
    public DeviceDTO update(DeviceRequest request) {
        // check params
        if (request == null || StringUtils.isAnyBlank(request.getId(), request.getTenantId(),
                request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // convert to entity
        Device device = deviceWrapper.convertTE(request);
        device = repository.saveAndFlush(device);
        return deviceWrapper.convertET(device);
    }

    @Override
    public List<DeviceDTO> list(DeviceRequest request) {
        // check
        if(request == null || StringUtils.isBlank(request.getTenantId())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        Specification<Device> conditions = createConditions(request);
        List<Device> devices = repository.findAll(conditions);
        if (CollectionUtil.isEmpty(devices)){
            return new ArrayList<>(0);
        }
        return devices.stream().map(device -> deviceWrapper.convertET(device)).toList();
    }

    @Override
    public PageResult<DeviceDTO> page(DeviceRequest request) {
        // check
        if(request == null || StringUtils.isBlank(request.getTenantId())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        Specification<Device> conditions = createConditions(request);
        Sort orders = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), orders);
        Page<Device> tenantPage = repository.findAll(conditions, pageRequest);
        List<Device> list = tenantPage.getContent();
        if (CollectionUtil.isEmpty(list)){
            return PageResult.of(new ArrayList<>(), tenantPage.getTotalElements(), request.getPageNo(), request.getPageSize());
        }
        List<DeviceDTO> dtoList = list.stream().map(device -> deviceWrapper.convertET(device)).toList();
        return PageResult.of(dtoList, tenantPage.getTotalElements(), request.getPageNo(), request.getPageSize());
    }

    /**
     * 构建检索条件
     * <p>
     * This is a method signature in Java that creates a Specification object,
     * which is used to define conditions for querying a database of Device objects.
     * The method takes a DeviceRequest object as input and returns a Specification<Device> object.
     * The Specification object can be used in conjunction with a CriteriaQuery object to build a query that retrieves devices that match the specified conditions.
     * This method is likely part of a larger service or repository class that manages interactions with the device database.
     *
     * @param request 请求参数
     * @return
     */
    private Specification<Device> createConditions(DeviceRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> condition = new ArrayList<>();
            String name = request.getName();
            if (StringUtils.isNotBlank(name)) {
                condition.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            DeviceStatus status = request.getStatus();
            if (status != null) {
                condition.add(criteriaBuilder.equal(root.get("status"), status.name()));
            }
            String specsId = request.getSpecsId();
            if (StringUtils.isNotBlank(specsId)) {
                condition.add(criteriaBuilder.equal(root.get("specsId"), specsId));
            }
            if (CollectionUtil.isEmpty(condition)) {
                return null;
            }
            Predicate[] predicates = condition.toArray(Predicate[]::new);
            return query.where(predicates).getRestriction();
        };
    }
}
