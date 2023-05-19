package com.changjiang.monitor.api.console.user;

import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.dto.user.UserLoginRequest;
import com.changjiang.monitor.dto.user.UserLoginResponse;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.log.Log;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.user.IUserService;
import com.changjiang.monitor.user.wrapper.UserTokenWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    @Resource
    private IUserService userService;

    /**
     * This method handles user login requests. It takes a UserLoginRequest object as the request body and a HttpServletResponse object as a response.
     * The method returns an Object representing the result of the login attempt.
     * This method first authenticates the user by checking if the provided credentials are valid. If the user is authenticated, it generates a token for the user and sets it in the response headers.
     * The token can be used by the client to make subsequent authenticated requests.
     * If the authentication fails, an appropriate error message is returned in the response.
     *
     * @param request  The UserLoginRequest object containing user credentials
     * @param response The HttpServletResponse object used to set the authentication token in the headers
     * @return An Object representing the result of the login attempt - either a success message or an error message
     */
    @PostMapping
    public Object login(@RequestBody UserLoginRequest request, HttpServletResponse response) {
        Log.topic("Login").log("request", request).log("tag", "beginLogin").info(log);
        // refresh login auth
        UserLoginResponse loginResponse = userService.login(request);
        Cookie cookie = new Cookie("gw_token", loginResponse.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        Log.topic("Login").log("request", request).log("response", response).log("tag", "finishLogin").info(log);
        return loginResponse;
    }

    /**
     * 当前登录用户信息
     *
     * @return
     */
    @GetMapping("/userInfo")
    public Object userInfo() {
        // Use Token find currentUser
        UserAuthDTO userAuth = UserTokenWrapper.currentUser();
        // check
        if (userAuth == null || StringUtils.isBlank(userAuth.getUserId())){
            throw new MonitorException(CodeEnum.IllegalUserToken);
        }
        UserDTO user = userService.findById(userAuth.getUserId());
        return user;
    }
}
