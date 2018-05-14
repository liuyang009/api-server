package io.common.apiserver.dao;

import io.common.apiserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project：api-server
 * @description：RoleDao
 * @author：five.liu
 * @creat_time：2018年05月14日18:47
 */
public interface RoleDao extends JpaRepository<Role, Long>{
}
