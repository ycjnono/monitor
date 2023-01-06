package com.changjiang.monitor.user.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.status.UserStatus;
import com.changjiang.monitor.dto.user.UserDTO;
import com.changjiang.monitor.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * 用户工具
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@Component
public class UserWrapper implements ObjectConvert<UserDTO, User> {

    @Override
    public UserDTO convertET(@NotNull User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtil.copyProperties(user, userDTO, "status");
        // 用户状态
        String status = user.getStatus();
        if (StringUtils.isNotBlank(status)){
            userDTO.setStatus(UserStatus.valueOf(status));
        }
        return userDTO;
    }

    @Override
    public User convertTE(@NotNull UserDTO userDTO) {
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        return user;
    }
}
