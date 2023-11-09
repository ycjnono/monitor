package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;

/**
 * 流类型配置
 *
 * @Author changjiang
 * @Date 2023/9/21 since beijing
 */
@Data
public class StreamConfig implements Serializable {

    /**
     * 流地址(RTSP\RTMP等)
     */
    private String streamUrl;

    /**
     * 控制台地址
     */
    private String consoleUrl;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

}
