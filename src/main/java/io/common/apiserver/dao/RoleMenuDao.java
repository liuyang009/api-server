package io.common.apiserver.dao;

import io.common.apiserver.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @project：api-server
 * @description：RoleMenuDao
 * @author：five.liu
 * @creat_time：2018年05月16日11:25
 */
public interface RoleMenuDao extends JpaRepository<RoleMenu, Long>{

    /**
     * 查询
     * @param roleId
     * @return
     */
    List<RoleMenu> findByRoleId(Long roleId);
    /**
     *  批量删除
     * @param roleId
     * @return
     */
    @Query(value = "delete from RoleMenu where roleId=?1")
    @Modifying
    int deleteByRoleId(Long roleId);
}
