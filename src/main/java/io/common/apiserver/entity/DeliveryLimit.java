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
 * @description ：提货限制
 * @create ：2018年06月03日8:50
 */
@Data
@Entity
@Table(name = "tb_delivery_limit")
public class DeliveryLimit {

    @Id
    @GeneratedValue
    private Long id;

    private Date startDate;

    private Date endDate;

    private String createUser;

    private int status;

    private String description;
}
