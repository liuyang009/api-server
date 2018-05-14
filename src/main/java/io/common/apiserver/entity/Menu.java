package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.*;
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

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Long parentId;

    @OneToMany
    @JoinColumn(name = "parentId")
    @OrderBy("id")
    private List<Menu> children;

    @Transient
    private MenuMeta meta;
}
