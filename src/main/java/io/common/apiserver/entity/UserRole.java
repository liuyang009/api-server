package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project：api-server
 * @description：UserRole
 * @author：five.liu
 * @creat_time：2018年05月16日10:02
 */
@Table(name = "sys_user_role")
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long roleId;
}
