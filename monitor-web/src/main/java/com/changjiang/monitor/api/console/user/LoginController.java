package com.changjiang.monitor.api.console.user;

import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.dto.user.UserLoginRequest;
import com.changjiang.monitor.log.Log;
import com.changjiang.monitor.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 登录
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@Slf4j
@RestController
@RequestMapping("/console/login")
public class LoginController {

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @PostMapping
    public Object login(@RequestBody UserLoginRequest request){
        Log.topic("Login").log("request", request).log("tag", "login").info(log);
        return true;
    }

    /**
     * 当前登录用户信息
     *
     * @return
     */
    @GetMapping("/userInfo")
    public Object userInfo(){
        UserDTO userDTO = new UserDTO();
        userDTO.setRole("admin");
        return userDTO;
    }
}
