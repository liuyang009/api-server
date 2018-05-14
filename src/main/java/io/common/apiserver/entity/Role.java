package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @project：api-server
 * @description：Role 角色
 * @author：five.liu
 * @creat_time：2018年05月14日18:10
 */
@Entity(name = "sys_role")
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 角色英文名
     */
    private String name;
    /**
     * 角色中文名
     */
    private String nameZh;
}
