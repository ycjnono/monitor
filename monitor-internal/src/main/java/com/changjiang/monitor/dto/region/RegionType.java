package com.changjiang.monitor.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 区域类型’
 *
 * @Author changjiang
 * @Date 2022/12/21 22:50 since beijing
 */
@Getter
@AllArgsConstructor
public enum RegionType {

    /**
     * 景区
     */
    ScenicSpot,

    /**
     * 社区
     */
    Community,

    /**
     * 活动
     */
    Activity,

    /**
     * 通用
     */
    Common
}
