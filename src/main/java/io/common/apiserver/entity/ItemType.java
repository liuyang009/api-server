package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：ItemType
 * @create ：2018年06月01日15:56
 */
@Data
@Entity
@Table(name = "tb_item_type")
public class ItemType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String createUser;

    private Date createTime;
}
