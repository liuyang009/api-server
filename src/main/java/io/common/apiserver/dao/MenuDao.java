package io.common.apiserver.dao;

import io.common.apiserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @project：api-server
 * @description：MenuDao
 * @author：five.liu
 * @creat_time：2018年05月14日16:59
 */
public interface MenuDao extends JpaRepository<Menu, Long>{

    /**
     * 根据父ID查询
     * @param id
     * @return
     */
    List<Menu> findByParentId(Long id);

    /**
     *  查询用户的菜单权限
     * @param username
     * @return
     */
    @Query(value = "SELECT * FROM sys_menu WHERE id in (select menu_id FROM sys_role_menu where role_id in (SELECT role_id FROM sys_user_role  sur LEFT JOIN sys_user su ON sur.user_id = su.id WHERE su.username=?1))", nativeQuery = true)
    List<Menu> listUserMenus(String username);
}
