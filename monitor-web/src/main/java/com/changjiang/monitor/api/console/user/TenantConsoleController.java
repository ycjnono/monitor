package com.changjiang.monitor.api.console.user;

import com.changjiang.monitor.dto.status.TenantStatus;
import com.changjiang.monitor.dto.user.TenantRequest;
import com.changjiang.monitor.exception.MonitorException;
import com.changjiang.monitor.result.CodeEnum;
import com.changjiang.monitor.user.ITenantService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 租户管理
 *
 * @Author changjiang
 * @Date 2022/12/12 since beijing
 */
@CrossOrigin
@RestController
@RequestMapping("/console/tenant")
public class TenantConsoleController {

    @Resource
    private ITenantService tenantService;

    /**
     * 分页检索
     *
     * @param name
     * @param status
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Object page(@RequestParam(required = false) String name, @RequestParam(required = false) String status,
                       @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize){
        TenantRequest request = new TenantRequest();
        request.setName(name);
        if (StringUtils.isNotBlank(status)){
            request.setStatus(TenantStatus.valueOf(status));
        }
        request.setPageNo(pageNo);
        request.setPageSize(pageSize);
        return tenantService.page(request);
    }

    /**
     * 新增租户
     *
     * @param request   请求参数
     * @return
     */
    @PostMapping
    public Object save(@RequestBody TenantRequest request){
        return tenantService.save(request);
    }

    /**
     * 修改
     *
     * @param request   请求参数
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestBody TenantRequest request){
        if (request == null || StringUtils.isBlank(request.getId())){
            throw new MonitorException(CodeEnum.IllegalArgument);
        }
        return tenantService.update(request);
    }

}
