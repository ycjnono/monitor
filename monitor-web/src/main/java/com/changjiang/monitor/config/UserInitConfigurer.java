package com.changjiang.monitor.config;

import com.changjiang.monitor.user.IUserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统用户初始化
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Component
public class UserInitConfigurer {

    @Resource
    private IUserService userService;

    private static final String RootUserName = "admin";

    @PostConstruct
    public void initRoot(){
        // 查询是否存在

    }

}
