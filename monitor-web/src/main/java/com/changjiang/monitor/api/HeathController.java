package com.changjiang.monitor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
@RestController
public class HeathController {

    /**
     * 当前时间
     *
     * @return
     */
    @GetMapping("/time")
    public String time(){
        return System.currentTimeMillis() + "";
    }

    /**
     * ok
     *
     * @return
     */
    @GetMapping("/ok")
    public String ok(){
        return "ok";
    }
}
