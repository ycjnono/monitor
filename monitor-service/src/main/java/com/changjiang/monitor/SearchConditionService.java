package com.changjiang.monitor;

import org.springframework.data.jpa.domain.Specification;

/**
 * @Author changjiang
 * @Date 2023/11/9
 */
public interface SearchConditionService<E, T> {

    /**
     * 查询参数构造器
     *
     * @param t 查询参数
     * @return  查询条件
     */
    Specification<E> createConditions(T t);
}
