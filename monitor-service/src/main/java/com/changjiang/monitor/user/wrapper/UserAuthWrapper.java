package com.changjiang.monitor.user.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.changjiang.monitor.dto.ObjectConvert;
import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.entity.UserAuth;
import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * 用户登录
 *
 * @Author changjiang
 * @Date 2023/4/20 since beijing
 */
@Component
public class UserAuthWrapper implements ObjectConvert<UserAuthDTO, UserAuth> {


    @Override
    public UserAuthDTO convertET(@NonNull UserAuth userAuth) {
        return BeanUtil.toBean(userAuth, UserAuthDTO.class);
    }

    @Override
    public UserAuth convertTE(@NonNull UserAuthDTO userAuthDTO) {
        return BeanUtil.toBean(userAuthDTO, UserAuth.class);
    }
}
