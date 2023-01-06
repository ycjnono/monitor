package com.changjiang.monitor.log;

import com.alibaba.fastjson2.JSONObject;
import com.changjiang.monitor.utils.RequestIdUtil;
import org.slf4j.Logger;

import java.util.TreeMap;


/**
 * 格式日志输出
 *
 * @Author changjiang
 * @Date 2022/12/11 since beijing
 */
public class Log extends TreeMap<String, Object> {

    /**
     * topic
     *
     * @param topic
     * @return
     */
    public static Log topic(String topic){
        Log log = new Log();
        log.put("requestId", RequestIdUtil.requestId());
        log.put("topic", topic);
        log.put("time", System.currentTimeMillis());
        return log;
    }

    /**
     * 补充日志
     *
     * @param tag
     * @param value
     * @return
     */
    public Log log(String tag, Object value){
        this.put(tag,value);
        return this;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    /**
     * info
     *
     * @param logger
     */
    public void info(Logger logger){
        logger.info(this.toString());
    }

    /**
     * warning
     *
     * @param logger
     */
    public void warn(Logger logger){
        logger.warn(this.toString());
    }

    /**
     * fail
     *
     * @param logger
     */
    public void fail(Logger logger, Throwable throwable){
        logger.error(this.toString(), throwable);
    }
}
