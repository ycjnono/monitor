package com.changjiang.monitor.dto.report;

import com.changjiang.monitor.base.KV;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 监控报告
 *
 * @Author changjiang
 * @Date 2023/6/16 since beijing
 */
@Data
public class MonitorReportResponse implements Serializable {

    private String title;



    private Date reportTime;

    private Date executeTime;

    private List<KV> data;
}
