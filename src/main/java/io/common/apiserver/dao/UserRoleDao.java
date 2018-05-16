package io.common.apiserver.dao;

import io.common.apiserver.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @project：api-server
 * @description：UserRoleDao
 * @author：five.liu
 * @creat_time：2018年05月16日10:03
 */
public interface UserRoleDao extends JpaRepository<UserRole, Long>{

    /**
     *  查询
     * @param id
     * @return
     */
    List<UserRole> findByUserId(Long id);

    /**
     *  批量删除
     * @param id
     * @return
     */
    @Query(value = "delete from UserRole where userId=?1")
    @Modifying
    int deleteUserRoleByUserId(Long id);
}
