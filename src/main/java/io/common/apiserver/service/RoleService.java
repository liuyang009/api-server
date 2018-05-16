package io.common.apiserver.service;

import io.common.apiserver.dao.RoleDao;
import io.common.apiserver.dao.RoleMenuDao;
import io.common.apiserver.dto.RoleMenuDto;
import io.common.apiserver.entity.Role;
import io.common.apiserver.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @project：api-server
 * @description：RoleService
 * @author：five.liu
 * @creat_time：2018年05月14日18:48
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    public Role save(Role role) {
        return roleDao.save(role);
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateRoleMenus(RoleMenuDto dto) {
        roleMenuDao.deleteByRoleId(dto.getRoleId());
        List<Long> menuIds = dto.getMenuIds();
        if (!menuIds.isEmpty()){
            List<RoleMenu> roleMenus = new ArrayList<>(menuIds.size());
            for (Long menuId : menuIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(dto.getRoleId());
                roleMenu.setMenuId(menuId);
                roleMenus.add(roleMenu);
            }
            roleMenuDao.save(roleMenus);
        }
    }
}
