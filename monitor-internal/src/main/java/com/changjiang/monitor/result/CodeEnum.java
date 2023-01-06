package com.changjiang.monitor.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码
 *
 * <p>
 *     规则：服务code+自定义状态码
 * </p>
 *
 * @Author changjiang
 * @Date 2022/12/11 1:18 since beijing
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {

    Success("100200", "请求成功"),
    IllegalArgument("100400", "参数错误"),
    IllegalArgumentNotFind("100404", "未找到指定资源"),
    IllegalArgumentRepeat("100401", "参数重复"),

    IllegalUserToken("100501", "用户token失效"),
    IllegalUserStatus("100502", "用户状态不正常"),
    IllegalUserPass("100503", "用户名或密码不正确"),


    ServerFail("100500", "服务运行异常"),
    ;

    /**
     * 状态码
     */
    private final String code;

    /**
     * 描述
     */
    private final String message;
}
