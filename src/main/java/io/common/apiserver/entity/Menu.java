package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * @project：api-server
 * @description：系统菜单
 * @author：five.liu
 * @creat_time：2018年05月14日14:52
 */
@Data
@Entity(name = "sys_menu")
public class Menu {

    private Long id;
    private String url;
    private String path;
    private Object component;
    private String name;
    private String iconCls;
    private Long parentId;

    @Transient
    private List<Menu> children;

    @Transient
    private MenuMeta meta;
}
