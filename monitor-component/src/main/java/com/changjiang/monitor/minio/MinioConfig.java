package com.changjiang.monitor.minio;

import com.changjiang.monitor.log.Log;
import io.minio.MinioClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * minio 配置
 *
 * @Author changjiang
 * @Date 2023/9/4 since beijing
 */
@Slf4j
@Component
public class MinioConfig implements InitializingBean {

    @Value("${minio.host}")
    private String host;

    @Getter
    @Value("${minio.url}")
    private String url;

    @Value("${minio.accessKey}")
    private String ak;

    @Value("${minio.secretKey}")
    private String sk;

    @Getter
    private MinioClient client;


    @Override
    public void afterPropertiesSet() {
        Log.topic("MinioConfig").log("status","start").log("ak",ak).log("sk",sk).info(log);
        client = MinioClient.builder().endpoint(host)
                .credentials(ak,sk).build();
        Log.topic("MinioConfig").log("status","startSuccess").log("ak",ak).log("sk",sk).info(log);
    }


}
