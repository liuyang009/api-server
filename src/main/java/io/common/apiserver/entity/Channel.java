package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：渠道
 * @create ：2018年06月01日13:10
 */
@Data
@Entity
@Table(name = "tb_channel")
public class Channel {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 渠道名称
     */
    private String name;
    /**
     * 0 禁用
     * 1 启用
     */
    private String status;
}
