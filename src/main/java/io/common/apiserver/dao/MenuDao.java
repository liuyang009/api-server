package io.common.apiserver.dao;

import io.common.apiserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project：api-server
 * @description：MenuDao
 * @author：five.liu
 * @creat_time：2018年05月14日16:59
 */
public interface MenuDao extends JpaRepository<Menu, Long>{

    /**
     * 根据父ID查询
     * @param id
     * @return
     */
    List<Menu> findByParentId(Long id);
}
