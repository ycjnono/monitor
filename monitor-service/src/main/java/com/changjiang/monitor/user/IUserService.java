package com.changjiang.monitor.user;

import com.changjiang.monitor.dto.user.CreateUserRequest;
import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.dto.user.UserLoginRequest;
import com.changjiang.monitor.dto.user.UserLoginResponse;
import org.jetbrains.annotations.NotNull;

/**
 * 系统用户服务接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface IUserService {

    /**
     * 登录
     *
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);

    /**
     * 创建用户
     *
     * @param request   请求参数
     * @return
     */
    UserDTO createUser(@NotNull CreateUserRequest request);

    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     */
    UserDTO findById(String userId);
}
