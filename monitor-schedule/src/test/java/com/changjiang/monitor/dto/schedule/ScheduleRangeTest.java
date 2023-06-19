package com.changjiang.monitor.dto.schedule;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 调度周期测试
 *
 * @Author changjiang
 * @Date 2023/6/20 since beijing
 */
public class ScheduleRangeTest {

    private final static ScheduleRange scheduleRange = new ScheduleRange();
    private final static ScheduleRange weekRange = new ScheduleRange();
    private final static ScheduleRange onceRange = new ScheduleRange();
    private final static ScheduleRange noneRange = new ScheduleRange();
    private final static ScheduleRange errorRange = new ScheduleRange();
    private final static ScheduleRange errorAfterRange = new ScheduleRange();
    private final static ScheduleRange errorDayRange = new ScheduleRange();
    private final static Date endingTime = DateUtil.tomorrow();
    private final static Date preTime = DateUtil.yesterday();
    private final static Date current = new Date();

    @BeforeAll
    public static void before(){
        DayRange dayRange = new DayRange();
        dayRange.setBeginTime("01:00");
        dayRange.setEndTime("02:00");
        scheduleRange.setDayRange(dayRange)
                .setTiming(Timing.Day)
                .setCurrent(current)
                .setPreScheduleTime(preTime)
                .setEndingTime(endingTime);

        List<Week> weeks = new ArrayList<>();
        weeks.add(Week.MONDAY);
        weeks.add(Week.TUESDAY);
        weekRange.setWeekRange(weeks)
                .setDayRange(dayRange)
                .setTiming(Timing.Week)
                .setCurrent(current)
                .setPreScheduleTime(preTime)
                .setEndingTime(endingTime);

        onceRange.setTiming(Timing.Once)
                .setCurrent(current)
                .setPreScheduleTime(preTime)
                .setEndingTime(endingTime);

        errorRange.setTiming(Timing.Day)
                .setEndingTime(preTime);
        errorAfterRange.setPreScheduleTime(endingTime)
                .setTiming(Timing.Day);
        errorDayRange.setTiming(Timing.Day)
                .setDayRange(null)
                .setEndingTime(endingTime);

        noneRange.setTiming(Timing.None)
                .setEndingTime(endingTime);
    }

    @Test
    public void testCheck(){
        System.out.println(scheduleRange.check());
        System.out.println(JSONObject.toJSONString(scheduleRange));
        String serializable = scheduleRange.serializable();
        System.out.println(serializable);
        ScheduleRange builder = ScheduleRangeBuilder.builder(serializable, preTime);
        System.out.println(builder.check());
        System.out.println(JSONObject.toJSONString(builder));
        System.out.println(builder.serializable());
        System.out.println(weekRange.check());
        System.out.println(weekRange.serializable());
        System.out.println(onceRange.check());
        System.out.println(errorRange.check());
        System.out.println(errorAfterRange.check());
        System.out.println(errorDayRange.check());
        System.out.println(noneRange.check());
    }

}
