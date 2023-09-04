package com.changjiang.monitor.user.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.entity.User;
import com.changjiang.monitor.entity.UserAuth;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.UserAuthRepository;
import com.changjiang.monitor.repository.UserRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.user.IUserAuthService;
import com.changjiang.monitor.user.wrapper.UserAuthWrapper;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户token相关服务接口
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Service
public class UserAuthServiceImpl implements IUserAuthService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserAuthRepository repository;

    @Resource
    private UserAuthWrapper userAuthWrapper;

    @Override
    public UserAuthDTO findByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        UserAuth userAuth = repository.findByToken(token);
        if (userAuth == null) {
            return null;
        }
        // 查询用户
        Optional<User> optional = userRepository.findById(userAuth.getUserId());
        if (optional.isEmpty()) {
            throw new MonitorException(CodeEnum.IllegalUserToken);
        }
        User user = optional.get();
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setUserId(user.getId());
        userAuthDTO.setToken(userAuth.getToken());
        userAuthDTO.setExpired(userAuth.getExpired());
        BeanUtil.copyProperties(user, userAuthDTO);
        return userAuthDTO;
    }

    @Override
    @Transactional
    public UserAuthDTO save(UserAuthDTO userAuth) {
        // check
        if (userAuth == null) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        if (StringUtils.isAnyBlank(userAuth.getUserId())) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        // exits
        UserAuth auth = repository.findByUserId(userAuth.getUserId());
        if (auth == null) {
            auth = userAuthWrapper.convertTE(userAuth);
        }
        // refresh token
        String token = IdUtil.fastSimpleUUID();
        auth.setToken(token);
        // save or update
        auth = repository.saveAndFlush(auth);
        return userAuthWrapper.convertET(auth);
    }
}
