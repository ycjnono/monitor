package com.changjiang.monitor.device;

import com.changjiang.monitor.base.KV;
import com.changjiang.monitor.dto.device.DeviceSpecsDTO;
import com.changjiang.monitor.dto.device.DeviceSpecsRequest;

import java.util.List;

/**
 * 设备规格服务接口
 *
 * @Author changjiang
 * @Date 2023/9/21
 */
public interface IDeviceSpecsService {

    /**
     * 保存设备规格
     *
     * @param request 请求参数
     * @return 设备规格
     */
    DeviceSpecsDTO save(DeviceSpecsRequest request);

    /**
     * 修改设备规格
     *
     * @param request 请求参数
     * @return 设备规格
     */
    DeviceSpecsDTO update(DeviceSpecsRequest request);

    /**
     * 获取所有的设备规格
     *
     * @param tenantId 租户id,查询所有可不传
     * @return 设备规格集合
     */
    List<DeviceSpecsDTO> list(String tenantId);

    /**
     * 获取所有的设备规格
     *
     * @param request   请求参数
     * @return  设备规格集合
     */
    List<DeviceSpecsDTO> list(DeviceSpecsRequest request);

    /**
     * 获取所有的设备规格
     *
     * @param tenantId 租户id, 查询所有可不传
     * @return 设备规格集合, K=id,V=name
     */
    List<KV> listSimple(String tenantId);

    /**
     * 根据id查找设备规格
     *
     * @param specsId 设备规格id
     * @return 设备规格
     */
    DeviceSpecsDTO findById(String specsId);
}
