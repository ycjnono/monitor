package com.changjiang.monitor.user;

import com.changjiang.monitor.dto.user.UserAuthDTO;

/**
 * 用户token相关服务接口
 *
 * @Author changjiang
 * @Date 2023/1/7
 */
public interface IUserAuthService {

    /**
     * This method is used to find the user authentication object using the provided token string.
     * If the token provided is empty or blank, then the token will be null.
     * If the user authentication object corresponding to the token isn't found, then the token will be null.
     * If the userDTO object corresponding to the user ID of the user authentication object isn't found, an illegal user token exception will be thrown.
     * Else, a new UserAuthDTO object will be created and the details of the UserDTO object and the UserAuth object will be copied into the new UserAuthDTO object, and it will be returned.
     *
     * @param token the token string used to find the corresponding user authentication object
     * @return the UserAuthDTO object containing the details of the user authentication object and the user object
     */
    UserAuthDTO findByToken(String token);

    /**
     * This method saves a UserAuthDTO object and returns the saved object.
     * It could be used for persisting user authentication data in a database or other storage medium.
     * The returned object may contain additional information such as a unique identifier assigned by the storage system.
     *
     * @param userAuth 登录信息
     * @return UserAuthDTO
     */
    UserAuthDTO save(UserAuthDTO userAuth);
}
