package io.common.apiserver.service;

import io.common.apiserver.dao.DeliveryLimitDao;
import io.common.apiserver.entity.DeliveryLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：DeliveryLimitService
 * @create ：2018年06月03日8:57
 */
@Service
public class DeliveryLimitService {

    @Autowired
    private DeliveryLimitDao deliveryLimitDao;

    public void save(DeliveryLimit limit) {
        deliveryLimitDao.save(limit);
    }

    public Page<DeliveryLimit> getPage(Pageable pageable) {
        return deliveryLimitDao.findAll(pageable);
    }
}
