package com.changjiang.monitor.dto.region;

import com.changjiang.monitor.dto.status.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域传输对象
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@Data
public class RegionDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 状态
     */
    private Status status;

    /**
     * 类型
     */
    private RegionType type;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 备注
     */
    private String remark;

    /**
     * 管理员id
     */
    private String manager;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
