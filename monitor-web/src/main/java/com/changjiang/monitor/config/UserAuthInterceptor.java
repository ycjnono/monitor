package com.changjiang.monitor.config;

import com.alibaba.fastjson2.JSONObject;
import com.changjiang.monitor.dto.status.UserStatus;
import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.log.Log;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.result.Result;
import com.changjiang.monitor.user.IUserAuthService;
import com.changjiang.monitor.user.wrapper.UserTokenWrapper;
import com.changjiang.monitor.utils.ClientIpUtil;
import com.changjiang.monitor.utils.RequestIdUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

/**
 * 用户登录鉴权
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Slf4j
@Component
public class UserAuthInterceptor implements HandlerInterceptor {

    @Resource
    private IUserAuthService userAuthService;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String gwToken = request.getHeader("gw_token");
        String remoteHost = ClientIpUtil.getRemoteHost(request);
        Log.topic("ConsoleLoginCheck").log("status", "checking").log("remoteHost",remoteHost).log("token", gwToken).info(log);
        if (StringUtils.isBlank(gwToken)){
            doResponse(CodeEnum.IllegalUserToken, response);
            return false;
        }
        UserAuthDTO userAuth = userAuthService.findByToken(gwToken);
        if (userAuth == null){
            doResponse(CodeEnum.IllegalUserToken, response);
            return false;
        }
        // token有效期
        if (userAuth.getExpired().getTime() < System.currentTimeMillis()){
            doResponse(CodeEnum.IllegalUserToken, response);
            return false;
        }
        // 用户状态
        UserStatus status = userAuth.getStatus();
        if (!UserStatus.Normal.equals(status)){
            doResponse(CodeEnum.IllegalUserStatus, response);
            return false;
        }
        // 置入thread
        UserTokenWrapper.putCurrentUser(userAuth);
        Log.topic("ConsoleLoginCheck").log("status", "success").log("remoteHost",remoteHost).log("token", gwToken).info(log);
        return true;
    }

    /**
     * 异常返回
     *
     * @param codeEnum
     * @param response
     * @throws IOException
     */
    private void doResponse(CodeEnum codeEnum, HttpServletResponse response) throws IOException {
        Result<Boolean> result = null;
        if (codeEnum.equals(CodeEnum.Success)){
            return;
        }else {
            result = Result.fail(RequestIdUtil.requestId(), codeEnum.getCode(), codeEnum.getMessage());
        }
        Log.topic("ConsoleLoginCheck").log("status", "fail").log("message", codeEnum.getMessage()).warn(log);
        response.setHeader("Content-Type", "application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result));
        response.getWriter().flush();
    }


}
