package com.changjiang.monitor.region;

import com.changjiang.monitor.dto.region.RegionDTO;
import com.changjiang.monitor.dto.region.RegionRequest;
import com.changjiang.monitor.result.PageResult;

/**
 * 区域服务接口
 * This is an interface for a region service which outlines the methods that should be implemented by any class that implements this interface.
 * The specific details of what these methods do will depend on the implementation.
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
public interface IRegionService {

    /**
     * This method saves a new RegionDTO object based on the provided RegionRequest object.
     *
     * @param request The RegionRequest object containing the necessary information for the creation of the new RegionDTO object.
     * @return The newly created RegionDTO object.
     */
    RegionDTO save(RegionRequest request);

    /**
     * This method updates a RegionDTO object based on the provided RegionRequest object.
     *
     * @param request The RegionRequest object containing the necessary information for the update.
     * @return The updated RegionDTO object.
     */
    RegionDTO update(RegionRequest request);

    /**
     * This code defines a method named "updateStatus" which takes in the ID of a region and a new status as input and returns a RegionDTO object containing the updated status.
     * The purpose of this method is to update the status of a region based on the input parameters provided by the client.
     * The method takes two string inputs - an ID and a new status. The ID is used to identify the region to be updated, while the new status is the updated status to be assigned to the region.
     * The method returns a RegionDTO object that contains details of the region with the updated status.
     * This method can be used to change the status of a region based on certain conditions like availability, activity, or location.
     *
     * @param id     The ID of the region to be updated
     * @param status The new status to be assigned to the region
     * @return RegionDTO object containing details of the region with the updated status
     */
    RegionDTO updateStatus(String id, String status);

    /**
     * This code defines a method named "page" which takes in a RegionRequest object as input and returns a PageResult object containing a list of RegionDTO objects.
     * This method is intended to provide pagination support for retrieving a list of regions based on the input parameters such as page number, page size, and filters provided in the RegionRequest object.
     * The PageResult object contains information about the current page, such as the total number of pages, total number of items, and the actual list of RegionDTO objects for the current page.
     * Implementing pagination can help to improve the system's efficiency by reducing the load on the server and giving the client an easy way to navigate through the data.
     *
     * @param request RegionRequest object containing input parameters like page number, page size, and filters
     * @return PageResult object containing a list of RegionDTO objects for the current page and pagination information
     */
    PageResult<RegionDTO> page(RegionRequest request);
}
