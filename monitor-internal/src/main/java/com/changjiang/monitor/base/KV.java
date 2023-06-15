package com.changjiang.monitor.base;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 通用key-value对象
 *
 * @Author changjiang
 * @Date 2023/5/24 since beijing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KV extends JSONObject {

    /**
     * key
     */
    private String key;

    /**
     * value
     */
    private Object value;

}
