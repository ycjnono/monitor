package com.changjiang.monitor.dto.schedule;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 调度对象
 *
 * @Author changjiang
 * @Date 2023/6/19 since beijing
 */
@Data
@Accessors(chain = true)
public class ScheduleRange implements Serializable {

    /**
     * 调度时间
     */
    private static final String RangeTimeTemplate = "yyyy-MM-dd HH:mm";
    /**
     * 当前年月日
     */
    private static final String DayTimeTemplate = "yyyy-MM-dd";

    /**
     * 时间整体选择
     * <p>
     *     1=day
     *     2=week
     *     3=once
     *     4=none
     * </p>
     */
    private Timing timing;

    /**
     * 天调度配置
     */
    private DayRange dayRange;

    /**
     * 星期调度配置
     */
    private List<Week> weekRange;

    /**
     * 单次调度时间
     */
    private Date onceTime;

    /**
     * 调度结束日期
     */
    private Date endingTime;

    /**
     * 当前时间
     */
    private Date current;

    /**
     * 上次调度时间
     */
    private Date preScheduleTime;


    /**
     * 判断当前是否处于调度周期内
     *
     * @return  是否处于调度周期内
     */
    public Boolean check(){
        Date now = new Date();
        // 已结束调度
        if (endingTime != null && endingTime.before(now)){
            return false;
        }
        // 上次调度时间在本次调度时间之后,理论上不存在
        if (preScheduleTime != null && preScheduleTime.after(now)){
            return false;
        }
        // 周期调度判定
        return switch (timing) {
            // 每天调度
            case Day -> currentDayCheck();
            // 星期调度
            case Week -> weekCheck();
            // 单次调度
            case Once -> preScheduleTime == null;
            default -> false;
        };
    }

    /**
     * 当天判定
     *
     * @return  判定结果
     */
    private boolean currentDayCheck(){
        if (this.dayRange == null || dayRange.getBeginTime() == null
                || dayRange.getEndTime() == null){
            return false;
        }
        // 获取当前年月日
        String day = DateUtil.format(current, DayTimeTemplate);
        // 调度日期
        String begin = day + " " + dayRange.getBeginTime();
        String end = day + " " + dayRange.getEndTime();
        Date beginTime = DateUtil.parse(begin, RangeTimeTemplate);
        Date endTime = DateUtil.parse(end, RangeTimeTemplate);
        return current.after(beginTime) && current.before(endTime);
    }

    /**
     * 星期判定
     *
     * @return  判定结果
     */
    private boolean weekCheck(){
        if (CollectionUtil.isEmpty(this.weekRange)){
            return false;
        }
        // 获取当前星期
        Week week = DateUtil.dayOfWeekEnum(current);
        if (weekRange.contains(week)){
            return currentDayCheck();
        }
        return false;
    }

    /**
     * 序列化
     *
     * @return  序列化结果字符串
     */
    public String serializable(){
        JSONObject range = BeanUtil.toBean(this, JSONObject.class);
        range.put("timing", timing.name());
        range.put("current", null);
        range.put("preScheduleTime", null);
        return JSONObject.toJSONString(range);
    }
}
