package com.changjiang.monitor.api.console.device;

import com.changjiang.monitor.device.IDeviceSpecsService;
import com.changjiang.monitor.dto.device.DeviceSpecsRequest;
import com.changjiang.monitor.dto.status.Status;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备规格控制器
 *
 * @Author changjiang
 * @Date 2023/11/9 since beijing
 */
@RestController
@RequestMapping("/console/device/specs")
public class DeviceSpecsController {

    @Resource
    private IDeviceSpecsService specsService;


    /**
     * This method is used to retrieve a list of objects based on the specified tenant ID, name, and status.
     *
     * @param tenantId The ID of the tenant for which the objects should be retrieved.
     * @param name     (Optional) The name parameter used to filter the objects.
     * @param status   (Optional) The status parameter used to filter the objects.
     * @return A list of objects that match the specified criteria.
     */
    @GetMapping("/list")
    public Object list(@RequestParam String tenantId, @RequestParam(required = false) String name,
                       @RequestParam(required = false) Status status) {
        DeviceSpecsRequest request = new DeviceSpecsRequest();
        request.setTenantId(tenantId);
        request.setName(name);
        request.setStatus(status);
        return specsService.list(request);
    }
}
