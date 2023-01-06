package com.changjiang.monitor.user;

import com.changjiang.monitor.dto.user.CreateUserRequest;
import com.changjiang.monitor.dto.user.UserDTO;

/**
 * 系统用户服务接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface IUserService {

    /**
     * 创建用户
     *
     * @param request   请求参数
     * @return
     */
    UserDTO createUser(CreateUserRequest request);

    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     */
    UserDTO findById(String userId);
}
