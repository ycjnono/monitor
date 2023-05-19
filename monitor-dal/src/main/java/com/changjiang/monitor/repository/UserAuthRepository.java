package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户登录相关持久化操作
 *
 * @Author changjiang
 * @Date 2023/1/7
 */
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String> {

    /**
     * 根据token查找
     *
     * @param token
     * @return
     */
    UserAuth findByToken(String token);

    /**
     * This method searches and retrieves the UserAuth object associated with the specified userId.
     * It is expected to return a single result since userId is unique for each user in the system.
     *
     * @param userId
     * @return
     */
    UserAuth findByUserId(String userId);
}
