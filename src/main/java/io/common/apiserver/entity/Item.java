package io.common.apiserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：TODO
 * @create ：2018年06月05日15:34
 */
@Data
@Entity
@Table(name = "tb_item")
public class Item {

    private Long id;

    private String name;

    private Long itemTypeId;
    /**
     * 进货价
     */
    private Long purchasePrice;
    /**
     * 售价
     */
    private Long price;
    /**
     * 商品规格
     */
    private String norms;
    /**
     * 商品介绍
     */
    private String description;
    /**
     * 商品主图
     */
    private String indexImage;

    /**
     * 商品展示图
     */
    private String viewImages;
}
