package com.changjiang.monitor.repository;

import com.changjiang.monitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户实体操作
 *
 * @Author changjiang
 * @Date 2022/12/11
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 根据用户名查找
     *
     * @param name
     * @return
     */
    User findByName(String name);
}
