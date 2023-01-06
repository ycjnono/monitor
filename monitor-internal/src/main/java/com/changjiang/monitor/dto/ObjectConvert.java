package com.changjiang.monitor.dto;

import lombok.NonNull;

/**
 * 参数转换接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface ObjectConvert<T, E> {

    /**
     * e to t
     *
     * <p>
     *     一般用于entity to dto
     * </p>
     * @param e 待转换参数
     * @return
     */
    T convertET(@NonNull E e);

    /**
     * t to e
     *
     * <p>
     *     一般用于 dto to entity
     * </p>
     * @param t 待转换参数
     * @return
     */
    E convertTE(@NonNull T t);
}
