package com.changjiang.monitor.utils.local;

import java.util.Map;
import java.util.TreeMap;

/**
 * 线程存储工具
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
public class ThreadLocalUtil {

    /**
     * 参数
     */
    private static ThreadLocal<Map<String, Object>> threadParams = new ThreadLocal<>();

    /**
     * 置入参数
     *
     * @param key   key
     * @param value value
     */
    public static void put(ThreadParamKey key, Object value) {
        Map<String, Object> params = threadParams.get();
        if (params == null){
            params = new TreeMap<>();
        }
        params.put(key.getKey(), value);
        threadParams.set(params);
    }

    /**
     * 获取参数
     *
     * @param key key
     * @return
     */
    public static Object get(ThreadParamKey key) {
        Map<String, Object> params = threadParams.get();
        if (params == null){
            return null;
        }
        return params.getOrDefault(key.getKey(), null);
    }
}
