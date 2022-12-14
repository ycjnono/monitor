package com.changjiang.monitor.user.impl;

import cn.hutool.core.bean.BeanUtil;
import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.entity.UserAuth;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.repository.UserAuthRepository;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.user.IUserAuthService;
import com.changjiang.monitor.user.IUserService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户token相关服务接口
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Service
public class UserAuthServiceImpl implements IUserAuthService {

    @Resource
    private IUserService userService;

    @Resource
    private UserAuthRepository repository;

    @Override
    public UserAuthDTO findByToken(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        UserAuth userAuth = repository.findByToken(token);
        if (userAuth == null){
            return null;
        }
        // 查询用户
        UserDTO userDTO = userService.findById(userAuth.getUserId());
        if (userDTO == null){
            throw new MonitorException(CodeEnum.IllegalUserToken);
        }
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setUserId(userDTO.getId());
        userAuthDTO.setToken(userAuth.getToken());
        userAuthDTO.setExpired(userAuth.getExpired());
        BeanUtil.copyProperties(userDTO, userAuthDTO);
        return userAuthDTO;
    }
}
