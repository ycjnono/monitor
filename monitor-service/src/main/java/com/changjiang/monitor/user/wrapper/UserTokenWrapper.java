package com.changjiang.monitor.user.wrapper;

import com.changjiang.monitor.dto.user.UserAuthDTO;
import com.changjiang.monitor.utils.local.ThreadLocalUtil;
import com.changjiang.monitor.utils.local.ThreadParamKey;

/**
 * 登录获取
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
public class UserTokenWrapper {

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static UserAuthDTO currentUser(){
        Object obj = ThreadLocalUtil.get(ThreadParamKey.ConsoleUser);
        if (obj != null){
            return (UserAuthDTO) obj;
        }
        return null;
    }

    /**
     * 保存当前用户
     *
     * @param userAuth
     */
    public static void putCurrentUser(UserAuthDTO userAuth){
        ThreadLocalUtil.put(ThreadParamKey.ConsoleUser, userAuth);
    }
}
