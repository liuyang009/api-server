package io.common.apiserver.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @project：api-server
 * @description：用户
 * @author：five.liu
 * @creat_time：2018年05月15日10:00
 */
@Entity(name = "sys_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
      */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;
    /**
     * 创建用户id
     */
    private Long userIdCreate;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 角色
     */
    @Transient
    private List<Role> roles;
    /**
     * 性别
     */
    private Long sex;
    /**
     * 出身日期
     */
    private Date birth;
}
