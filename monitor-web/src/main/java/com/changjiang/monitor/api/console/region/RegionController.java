package com.changjiang.monitor.api.console.region;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.region.IRegionService;
import com.changjiang.monitor.result.PageResult;
import jakarta.annotation.Resource;
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
                       @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize) {
        return PageResult.of(new ArrayList<>(), 0L, pageNo, pageSize);
    }

    /**
     * 保存
     *
     * @param request   请求参数
     * @return
     */
    @PostMapping
    public Object save(@RequestBody RegionRequest request){
        return new RegionDTO();
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

    @PutMapping("/{id}")
    public Object updateStatus(@PathVariable String id, @RequestBody RegionRequest request){
        return new RegionDTO();
    }
}
