package com.changjiang.monitor.api.console.region;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.dto.status.RegionStatus;
import com.changjiang.monitor.dto.status.TenantStatus;
import com.changjiang.monitor.region.IRegionService;
import com.changjiang.monitor.result.PageResult;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 区域
 *
 * @Author changjiang
 * @Date 2022/12/21 since beijing
 */
@RestController
@RequestMapping("/console/region")
public class RegionController {

    @Resource
    private IRegionService regionService;

    /**
     * 分页检索
     *
     * @param tenantId 租户id
     * @param name     名称
     * @param status   状态
     * @param type     类型
     * @param parent   主区域
     * @param pageNo   分页参数
     * @param pageSize 分页参数
     * @return
     */
    @GetMapping("/page")
    public Object page(@RequestParam String tenantId, @RequestParam(required = false) String name,
                       @RequestParam(required = false) String status, @RequestParam(required = false) String type,
                       @RequestParam(required = false) Boolean parent,
                       @RequestParam(defaultValue = "0") Integer pageNo,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        RegionRequest request = new RegionRequest();
        request.setName(name);
        if (StringUtils.isNotBlank(status)) {
            request.setStatus(RegionStatus.valueOf(status));
        }
        request.setTenantId(tenantId);
        request.setPageNo(pageNo);
        request.setPageSize(pageSize);
        return regionService.page(request);
    }

    /**
     * 保存
     *
     * @param request   请求参数
     * @return
     */
    @PostMapping
    public Object save(@RequestBody RegionRequest request){
        return regionService.save(request);
    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    @PutMapping("/{id}")
    public Object update(@PathVariable String id, @RequestBody RegionRequest request){
        return new RegionDTO();
    }

    @PutMapping("/updateStatus/{id}")
    public Object updateStatus(@PathVariable String id, @RequestBody RegionRequest request){
        return new RegionDTO();
    }
}
