package com.cj.iotmonitor.monitoretl.data;

import com.cj.iotmonitor.monitoretl.service.DeviceShadowService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 数据消费
 *
 * @Author changjiang
 * @Date 2023/6/8 since beijing
 */
@Component
public class DeviceDataConsumer {

    @Value("${system.data.etl.mq.topic}")
    private String topic;

    @Value("${system.data.etl.mq.ak}")
    private String ak;

    @Value("${system.data.etl.mq.sk}")
    private String sk;

    @Value("${system.data.etl.mq.groupId}")
    private String groupId;

    @Resource
    private DeviceShadowService deviceShadowService;

    /**
     * 初始化consumer
     */
    @PostConstruct
    public void consumer(){
        // 初始化consumer
        // 订阅topic,group
        // 清洗,入库

    }



}
