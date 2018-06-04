package io.common.apiserver.dao;

import io.common.apiserver.entity.DeliveryLimit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：DeliveryLimitDao
 * @create ：2018年06月03日8:56
 */
public interface DeliveryLimitDao extends JpaRepository<DeliveryLimit, Long>{
}
