package com.changjiang.monitor.dto.message;

import lombok.Getter;

/**
 * 消息发送类型
 *
 * @Author changjiang
 * @Date 2023/6/16 17:47 since beijing
 */
@Getter
public enum MessageSendType {

    SMS,
    WeChat,
    DingTalkRobot,
    WebHook,
    Email,
    MQ
}
