package com.changjiang.monitor.device;

import com.changjiang.monitor.dto.device.DeviceDTO;
import com.changjiang.monitor.dto.device.DeviceRequest;
import com.changjiang.monitor.result.PageResult;

import java.util.List;

/**
 * 设备服务接口
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface IDeviceService {

    /**
     * 保存设备
     *
     * @param request
     * @return
     */
    DeviceDTO save(DeviceRequest request);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    DeviceDTO findById(String id);

    /**
     * 修改设备
     *
     * @param request
     * @return
     */
    DeviceDTO update(DeviceRequest request);

    /**
     * 根据条件查找所有
     *
     * @param request
     * @return
     */
    List<DeviceDTO> list(DeviceRequest request);

    /**
     * 分页查找
     *
     * @param request
     * @return
     */
    PageResult<DeviceDTO> page(DeviceRequest request);
}
