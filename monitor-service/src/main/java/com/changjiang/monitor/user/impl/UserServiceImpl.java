package com.changjiang.monitor.user.impl;

import com.changjiang.monitor.dto.user.CreateUserRequest;
import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.entity.User;
import com.changjiang.monitor.repository.UserRepository;
import com.changjiang.monitor.user.IUserService;
import com.changjiang.monitor.user.wrapper.UserWrapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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

    @Override
    public UserDTO createUser(CreateUserRequest request) {
        return null;
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
