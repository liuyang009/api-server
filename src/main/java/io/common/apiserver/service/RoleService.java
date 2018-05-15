package io.common.apiserver.service;

import io.common.apiserver.dao.RoleDao;
import io.common.apiserver.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Role save(Role role) {
        return roleDao.save(role);
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void delete(Long id) {
        roleDao.delete(id);
    }
}
