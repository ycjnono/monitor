package com.changjiang.monitor.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 一般传输对象
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
public class BaseDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 租户id
     */
    private String tenantId;
}
