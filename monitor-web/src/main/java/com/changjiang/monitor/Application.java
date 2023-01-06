package com.changjiang.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@SpringBootApplication(scanBasePackages = "com.changjiang.monitor")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
