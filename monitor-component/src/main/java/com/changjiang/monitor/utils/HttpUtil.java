package com.changjiang.monitor.utils;

import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.utils.local.ThreadParamKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 封装http请求
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
public class HttpUtil<T> {

    /**
     * 超时时间
     */
    private static final int readTimeOut = 60 * 1000;

    private static final int connectTimeOut = 60 * 1000;

    /**
     * 默认增加头
     */
    private static final String AccessTokenHeaderKey = "accessToken";
    private static final String AccessTokenHeaderValue = "1";

    /**
     * http获取对象list
     *
     * @param url         请求url
     * @param params      请求参数, value无需encode
     * @param resultClazz 返回类型
     * @param <T>         返回类型
     * @return optional操作对象
     */
    public static <T> Optional<List<T>> getList(String url, Map<String, String> params,
                                                Class<T> resultClazz) {
        // params 处理
        String path = processUrlGet(url, params);
        return requestList(path, Method.GET, resultClazz);
    }

    /**
     * http获取对象
     *
     * @param url         请求url
     * @param params      请求参数, value无需encode
     * @param resultClazz 返回类型
     * @param <T>         返回类型
     * @return optional操作对象
     */
    public static <T> Optional<T> get(String url, Map<String, String> params, Class<T> resultClazz) {
        // params 处理
        String path = processUrlGet(url, params);
        return request(path, Method.GET, resultClazz);
    }

    /**
     * 处理get请求的params
     *
     * @param url    url
     * @param params 请求参数map
     * @return 参数段
     */
    private static String processUrlGet(String url, Map<String, String> params) {
        if (url == null || "".equals(url)) {
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        if (params == null || params.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String value = entry.getValue();
            if (value == null || value.isEmpty()) {
                value = "";
            }
            value = URLEncodeUtil.encode(value);
            sb.append(entry.getKey()).append("=").append(value).append("&");
        }
        String paramsUrl = sb.substring(0, sb.length() - 1);
        if (url.endsWith("?")) {
            return url + paramsUrl;
        }
        return url + "?" + paramsUrl;
    }

    /**
     * 通用请求方法
     *
     * @param path        请求全路径, get/option请求需完整带参路径
     * @param method      请求方式
     * @param resultClazz 返回类型
     * @param <T>         返回类型
     * @return optional操作对象
     */
    private static <T> Optional<T> request(String path, Method method, Class<T> resultClazz) {
        HttpRequest request = cn.hutool.http.HttpUtil.createRequest(method, path);
        setDefault(request);
        try {
            HttpResponse response = request.execute();
            String body = preHandlerResponse(response);
            return Optional.ofNullable(processResponse(body, resultClazz));
        } catch (Exception e) {
            if (e instanceof MonitorException) {
                throw e;
            }
            throw new MonitorException(CodeEnum.ApiServerFail);
        }
    }

    /**
     * 通用请求方法
     *
     * @param path        请求全路径, get/option请求需完整带参路径
     * @param method      请求方法
     * @param resultClazz 返回类型
     * @param <T>         返回类型
     * @return 操作对象
     */
    private static <T> Optional<List<T>> requestList(String path, Method method, Class<T> resultClazz) {
        HttpRequest request = cn.hutool.http.HttpUtil.createRequest(method, path);
        setDefault(request);
        try {
            HttpResponse response = request.execute();
            String body = preHandlerResponse(response);
            return Optional.ofNullable(processResponseList(body, resultClazz));
        } catch (Exception e) {
            if (e instanceof MonitorException) {
                throw e;
            }
            throw new MonitorException(CodeEnum.ApiServerFail);
        }
    }

    /**
     * 处理http请求结果
     *
     * @param response 请求结果
     * @return body
     */
    private static String preHandlerResponse(HttpResponse response) {
        if (!response.isOk()) {
            throw new MonitorException(CodeEnum.ApiServerResponseStatusFail);
        }
        return response.body();
    }

    /**
     * 处理返回结果
     *
     * @param body  http回文内容
     * @param clazz 返回对象类型
     * @param <T>   返回对象类型
     * @return 返回对象
     */
    private static <T> T processResponse(String body, Class<T> clazz) {
        if ("".equals(body) || body == null) {
            return null;
        }
        return JSONObject.parseObject(body, clazz);
    }

    /**
     * 处理返回结果
     *
     * @param body  http回文内容
     * @param clazz 返回对象类型
     * @param <T>   返回对象类型
     * @return 返回对象集合
     */
    private static <T> List<T> processResponseList(String body, Class<T> clazz) {
        if ("".equals(body) || body == null) {
            return new ArrayList<>();
        }
        return JSONB.parseArray(body.getBytes(), clazz);
    }

    /**
     * 默认参数, header,timeout等
     *
     * @param request http请求对象
     */
    private static void setDefault(HttpRequest request) {
        request.setReadTimeout(readTimeOut);
        request.setConnectionTimeout(connectTimeOut);
        request.header(ThreadParamKey.RequestId.getKey(), RequestIdUtil.requestId());
        request.contentType("application/json");
        // token
        request.header(AccessTokenHeaderKey, AccessTokenHeaderValue);
    }
}
