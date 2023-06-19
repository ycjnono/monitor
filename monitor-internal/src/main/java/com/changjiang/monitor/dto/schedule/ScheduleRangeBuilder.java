package com.changjiang.monitor.dto.schedule;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.BeanUtils;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.result.CodeEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 调度周期对象构造器
 *
 * @Author changjiang
 * @Date 2023/6/20 since beijing
 */
public class ScheduleRangeBuilder {

    /**
     * 构造调度周期对象
     *
     * @param preScheduleTime 上次调度时间
     * @return 调度周期对象
     */
    public static ScheduleRange builder(String scheduleRangeStr, Date preScheduleTime) {
        if (StringUtils.isBlank(scheduleRangeStr)){
            throw new MonitorException(CodeEnum.ScheduleConfigFail);
        }
        ScheduleRange scheduleRange = new ScheduleRange();
        scheduleRange.setCurrent(new Date());
        scheduleRange.setPreScheduleTime(preScheduleTime);
        JSONObject object = JSONObject.parse(scheduleRangeStr);
        BeanUtil.copyProperties(object, scheduleRange);
        return scheduleRange;
    }
}
