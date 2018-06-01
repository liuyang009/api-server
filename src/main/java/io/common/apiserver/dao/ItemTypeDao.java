package io.common.apiserver.dao;

import io.common.apiserver.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：ItemTypeDao
 * @create ：2018年06月01日15:58
 */
public interface ItemTypeDao extends JpaRepository<ItemType, Long>,JpaSpecificationExecutor<ItemType> {

    /**
     *  查询
     * @param name
     * @return
     */
    ItemType findByName(String name);

}
