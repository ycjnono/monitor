package com.changjiang.monitor.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @Id
    @Column(length = 55)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 额外属性
     */
    @Column(name = "feature")
    private String feature = "{}";

    /**
     * 版本
     */
    @Column(name = "version")
    private Long version = 1L;

    /**
     * 删除标识
     */
    @Column(name = "deleted")
    private Boolean deleted = false;

}
