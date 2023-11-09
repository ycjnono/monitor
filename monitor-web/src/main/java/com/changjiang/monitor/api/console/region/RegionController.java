package com.changjiang.monitor.api.console.region;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.dto.status.RegionStatus;
import com.changjiang.monitor.region.IRegionService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

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
     * This method is used to retrieve a page of objects based on the provided parameters.
     *
     * @param tenantId  The ID of the tenant for which the objects should be retrieved.
     * @param name      The name of the objects to be retrieved (optional).
     * @param status    The status of the objects to be retrieved (optional).
     * @param type      The type of the objects to be retrieved (optional).
     * @param parent    Indicates if the objects should be parent objects (optional).
     * @param pageNo    The page number of the results to be retrieved (default value: 0).
     * @param pageSize  The maximum number of results per page (default value: 10).
     * @return          The page of objects matching the provided criteria.
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
