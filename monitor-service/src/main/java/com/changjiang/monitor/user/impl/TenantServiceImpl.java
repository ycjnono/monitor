package com.changjiang.monitor.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.changjiang.monitor.dto.status.TenantStatus;
import com.changjiang.monitor.dto.user.CreateUserRequest;
import com.changjiang.monitor.dto.user.CreateUserType;
import com.changjiang.monitor.dto.user.TenantDTO;
import com.changjiang.monitor.dto.user.TenantRequest;
import com.changjiang.monitor.entity.Tenant;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.TenantRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.PageResult;
import com.changjiang.monitor.user.ITenantService;
import com.changjiang.monitor.user.IUserService;
import com.changjiang.monitor.user.wrapper.TenantWrapper;
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
 * 租户服务实现
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Service
public class TenantServiceImpl implements ITenantService {

    @Resource
    private TenantRepository repository;

    @Resource
    private TenantWrapper tenantWrapper;

    @Resource
    private IUserService userService;

    @Override
    public TenantDTO save(TenantRequest request) {
        if (request == null || StringUtils.isBlank(request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // 名称是否重复
        Tenant exits = repository.findByName(request.getName());
        if (exits != null){
            throw new MonitorException(CodeEnum.IllegalArgumentRepeat, "租户名称重复");
        }
        Tenant tenant = tenantWrapper.convertTE(request);
        tenant.setStatus(TenantStatus.UnActive.name());
        // 保存
        tenant = repository.saveAndFlush(tenant);

        // 创建管理员账号
        CreateUserRequest createUserRequest= new CreateUserRequest();
        createUserRequest.setCreateUserType(CreateUserType.TenantInit);
        createUserRequest.setExpiredTime(tenant.getExpiredTime());
        createUserRequest.setPhoneNumber(tenant.getManagePhoneNumber());
        createUserRequest.setEmail(tenant.getManageEmail());
        createUserRequest.setName("admin@" + tenant.getDomain());
        createUserRequest.setNickName(tenant.getName());
        createUserRequest.setPassword(DigestUtil.md5Hex("1q2w3e4R"));
        userService.createUser(createUserRequest);
        return tenantWrapper.convertET(tenant);
    }

    @Override
    public TenantDTO update(TenantRequest request) {
        // 参数校验
        if (request == null || StringUtils.isAnyBlank(request.getId(), request.getName())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // 是否存在
        Optional<Tenant> optional = repository.findById(request.getId());
        if (optional.isEmpty()){
            throw new MonitorException(CodeEnum.IllegalArgumentNotFind);
        }

        // 名称重复
        Tenant byName = repository.findByName(request.getName());
        if (byName != null && !byName.getId().equals(request.getId())){
            throw new MonitorException(CodeEnum.IllegalArgumentRepeat, "租户名称重复");
        }

        // 保存
        Tenant tenant = optional.get();
        tenant.setName(request.getName());
        tenant.setStatus(request.getStatus().name());
        tenant.setExpiredTime(request.getExpiredTime());
        tenant.setRemark(request.getRemark());
        tenant = repository.saveAndFlush(tenant);
        return tenantWrapper.convertET(tenant);
    }

    @Override
    public TenantDTO findById(String tenantId) {
        return null;
    }

    @Override
    public Boolean deleteById(String tenantId) {
        return null;
    }

    @Override
    public PageResult<TenantDTO> page(TenantRequest request) {
        if (request == null){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }

        Sort orders = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), orders);
        Specification<Tenant> conditions = (root, query, criteriaBuilder) -> {
            List<Predicate> condition = new ArrayList<>();
            String name = request.getName();
            if (StringUtils.isNotBlank(name)) {
                condition.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            TenantStatus status = request.getStatus();
            if (status != null) {
                condition.add(criteriaBuilder.equal(root.get("status"), status.name()));
            }

            if (CollectionUtil.isEmpty(condition)){
                return null;
            }
            Predicate[] predicates = condition.toArray(Predicate[]::new);
            return query.where(predicates).getRestriction();
        };
        Page<Tenant> tenantPage = repository.findAll(conditions, pageRequest);
        List<Tenant> list = tenantPage.getContent();
        if (CollectionUtil.isEmpty(list)){
            return PageResult.of(new ArrayList<>(), tenantPage.getTotalElements(), request.getPageNo(), request.getPageSize());
        }
        List<TenantDTO> dtoList = list.stream().map(tenant -> tenantWrapper.convertET(tenant)).toList();
        return PageResult.of(dtoList, tenantPage.getTotalElements(), request.getPageNo(), request.getPageSize());
    }

    @Override
    public List<TenantDTO> findAll(TenantRequest request) {
        return null;
    }
}
