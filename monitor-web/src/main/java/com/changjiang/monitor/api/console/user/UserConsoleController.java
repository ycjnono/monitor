package com.changjiang.monitor.api.console.user;

import com.changjiang.monitor.dto.user.CreateUserRequest;
import com.changjiang.monitor.user.IUserAuthService;
import com.changjiang.monitor.user.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @Author changjiang
 * @Date 2023/1/2 since beijing
 */
@RestController
@RequestMapping("/console/user")
public class UserConsoleController {

    @Resource
    private IUserService userService;

    /**
     * 用户注册
     *
     * @param request
     * @return
     */
    @PostMapping("/sign")
    public Object sign(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }
}
