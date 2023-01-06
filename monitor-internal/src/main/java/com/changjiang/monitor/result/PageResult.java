package com.changjiang.monitor.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果集
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * 分页参数
     */
    private Integer pageNo;

    /**
     * 分页参数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> items;

    /**
     * 静态构建page
     *
     * @param items
     * @param total
     * @param pageNo
     * @param pageSize
     * @return
     * @param <T>
     */
    public static <T> PageResult<T> of(List<T> items, Long total, Integer pageNo, Integer pageSize){
        PageResult<T> result = new PageResult<>();
        result.pageNo = pageNo;
        result.pageSize = pageSize;
        result.items = items;
        result.total = total;
        return result;
    }
}
