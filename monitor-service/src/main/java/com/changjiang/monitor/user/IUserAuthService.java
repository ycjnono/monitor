package com.changjiang.monitor.user;

import com.changjiang.monitor.dto.user.UserAuthDTO;

/**
 * 用户token相关服务接口
 *
 * @Author changjiang
 * @Date 2023/1/7
 */
public interface IUserAuthService {

    /**
     * 根据token获取登录用户
     *
     * @param token 登录token
     * @return
     */
    UserAuthDTO findByToken(String token);
}
