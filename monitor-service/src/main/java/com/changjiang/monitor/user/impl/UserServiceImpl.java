package com.changjiang.monitor.user.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.changjiang.monitor.dto.status.UserStatus;
import com.changjiang.monitor.dto.user.*;
import com.changjiang.monitor.entity.Tenant;
import com.changjiang.monitor.entity.User;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.TenantRepository;
import com.changjiang.monitor.repository.UserAuthRepository;
import com.changjiang.monitor.repository.UserRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.user.ITenantService;
import com.changjiang.monitor.user.IUserAuthService;
import com.changjiang.monitor.user.IUserService;
import com.changjiang.monitor.user.wrapper.UserWrapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * 用户服务接口实现
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserRepository repository;

    @Resource
    private UserWrapper userWrapper;

    @Resource
    private TenantRepository tenantRepository;

    @Resource
    private IUserAuthService userAuthService;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (StringUtils.isAnyBlank(username, password)){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }

        // 根据用户名查找
        User user = repository.findByName(username);
        if (user == null){
            throw new MonitorException(CodeEnum.IllegalArgumentNotFind);
        }
        // 密码匹配
        if (!StringUtils.equals(password, user.getPassword())){
            throw new MonitorException(CodeEnum.IllegalUserPass);
        }
        // 用户状态
        if (!StringUtils.equals(UserStatus.Normal.name(), user.getStatus())){
            throw new MonitorException(CodeEnum.IllegalUserStatus);
        }

        // 生成Token,插入登录表
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setUserId(user.getId());
        userAuthDTO.setTenantId(user.getTenantId());
        userAuthDTO.setExpired(DateUtil.nextMonth());
        UserAuthDTO authDTO = userAuthService.save(userAuthDTO);

        UserLoginResponse response = new UserLoginResponse();
        response.setToken(authDTO.getToken());
        return response;
    }

    @Override
    public UserDTO createUser(@NotNull CreateUserRequest request) {
        // check
        CreateUserType createUserType = request.getCreateUserType();
        if (createUserType == null){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        String name = request.getName();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();
        String tenantId = request.getTenantId();
        if (StringUtils.isAnyBlank(name, password, phoneNumber, tenantId)){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // password
        password = DigestUtil.md5Hex(password);
        Date expiredTime = request.getExpiredTime();
        if (expiredTime == null){
            expiredTime = DateUtil.nextMonth();
        }
        request.setExpiredTime(expiredTime);
        // 租户
        Optional<Tenant> optional = tenantRepository.findById(tenantId);
        if (optional.isEmpty()){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }

        // 新增用户
        User user = userWrapper.convertTE(request);
        user.setPassword(password);
        user = repository.save(user);
        return userWrapper.convertET(user);
    }

    @Override
    public UserDTO findById(String userId) {
        if (StringUtils.isBlank(userId)){
            return null;
        }
        Optional<User> optional = repository.findById(userId);
        return optional.map(user -> userWrapper.convertET(user)).orElse(null);
    }
}
