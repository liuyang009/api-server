package io.common.apiserver.service;

import com.google.common.collect.Lists;
import io.common.apiserver.dao.MenuDao;
import io.common.apiserver.dao.RoleMenuDao;
import io.common.apiserver.entity.Menu;
import io.common.apiserver.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project：api-server
 * @description：MenuService
 * @author：five.liu
 * @creat_time：2018年05月14日16:59
 */
@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    public List<Menu> findByParentId(Long id) {
        return menuDao.findByParentId(id);
    }

    /**
     *  菜单Id列表
     * @param roleId
     * @return
     */
    public List<Long> findByRoleId(Long roleId) {
        List<RoleMenu> roleMenus = roleMenuDao.findByRoleId(roleId);
        if (roleMenus == null || roleMenus.isEmpty()){
            return Lists.newArrayList();
        }
        return roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
    }

    public Menu findOne(Long distinctId) {
        return menuDao.findOne(distinctId);
    }
}
