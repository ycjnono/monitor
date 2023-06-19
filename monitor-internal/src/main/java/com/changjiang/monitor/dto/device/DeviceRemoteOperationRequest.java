package com.changjiang.monitor.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备远程操作
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class DeviceRemoteOperationRequest implements Serializable {

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 关机参数
     * <p>
     *     1 = now
     *     2 = custom time
     * </p>
     */
    private int shutdown;

    /**
     * 关机时间
     */
    private Date shutDownTime;

    /**
     * 自检参数
     * <p>
     *     1 = now
     *     2 = custom
     *     3 = leisure
     *     4 = pre shutdown
     * </p>
     */
    private int selfCheck;

    /**
     * 自检时间
     */
    private Date selfCheckTime;
}
