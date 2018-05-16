package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project：api-server
 * @description：RoleMenu
 * @author：five.liu
 * @creat_time：2018年05月16日11:23
 */
@Table(name = "sys_role_menu")
@Entity
@Data
public class RoleMenu {

    @Id
    @GeneratedValue
    private Long id;

    private Long roleId;

    private Long menuId;
}
