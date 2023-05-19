package com.changjiang.monitor.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * web配置
 *
 * @Author changjiang
 * @Date 2023/1/7 since beijing
 */
@SpringBootConfiguration
public class MonitorConfigurer extends WebMvcConfigurationSupport {

    @Resource
    private UserAuthInterceptor userAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // console
//        List<String> consolePath = List.of("/console/**");
//        List<String> consoleLoginPath = List.of("/console/login");
//        registry.addInterceptor(userAuthInterceptor)
//                .addPathPatterns(consolePath)
//                .excludePathPatterns(consoleLoginPath);
    }
}
