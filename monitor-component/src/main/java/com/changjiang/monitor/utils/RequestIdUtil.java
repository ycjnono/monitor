package com.changjiang.monitor.utils;

import com.changjiang.monitor.utils.local.ThreadLocalUtil;
import com.changjiang.monitor.utils.local.ThreadParamKey;

import java.util.UUID;

/**
 * requestId工具类
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
public class RequestIdUtil {

    /**
     * 获取requestId,如果为空,则生成一个
     * @return
     */
    public static String requestId(){
        String requestId = (String)ThreadLocalUtil.get(ThreadParamKey.RequestId);
        if (requestId == null || requestId.equals("")){
            requestId = UUID.randomUUID().toString().replace("-","");
            ThreadLocalUtil.put(ThreadParamKey.RequestId, requestId);
        }
        return requestId;
    }
}
