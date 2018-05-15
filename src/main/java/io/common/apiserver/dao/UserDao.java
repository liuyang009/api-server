package io.common.apiserver.dao;

import io.common.apiserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @project：api-server
 * @description：UserDao
 * @author：five.liu
 * @creat_time：2018年05月15日13:42
 */
public interface UserDao extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {
}
