package com.changjiang.monitor.api.console.device;

import com.changjiang.monitor.device.IDeviceService;
import com.changjiang.monitor.dto.device.DeviceRequest;
import com.changjiang.monitor.dto.status.DeviceStatus;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 设备管理
 *
 * @Author changjiang
 * @Date 2023/9/20 since beijing
 */
@RestController
@RequestMapping("/console/device")
public class DeviceController {

    @Resource
    private IDeviceService deviceService;

    /**
     * This method is used to fetch a page of objects based on the provided parameters.
     *
     * @param tenantId The ID of the tenant.
     * @param regionId (Optional) The ID of the region.
     * @param name     (Optional) The name of the object.
     * @param status   (Optional) The status of the object.
     * @param order    (Optional) The order of the objects.
     * @param specsId  (Optional) The specsId of the objects.
     * @param pageNo   (Default: 0) The page number to retrieve.
     * @param pageSize (Default: 10) The maximum number of objects per page.
     * @return The page of objects based on the provided parameters.
     */
    @GetMapping("/page")
    public Object page(@RequestParam String tenantId, @RequestParam(required = false) String regionId,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String status, @RequestParam(required = false) Integer order,
                       @RequestParam(required = false) String specsId,
                       @RequestParam(defaultValue = "0") Integer pageNo,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        DeviceRequest request = DeviceRequest.builder().pageNo(pageNo).pageSize(pageSize).build();
        request.setTenantId(tenantId);
        request.setRegionId(regionId);
        request.setName(name);
        if (StringUtils.isNotBlank(status)) {
            request.setStatus(DeviceStatus.valueOf(status));
        }
        request.setSpecsId(specsId);
        request.setOrder(order);
        return deviceService.page(request);
    }

    /**
     * This method is used to save a device object based on the provided request.
     *
     * @param request The device request object containing the information to be saved.
     * @return The saved device object.
     */
    @PostMapping
    public Object save(@RequestBody DeviceRequest request){
        return deviceService.save(request);
    }
}
