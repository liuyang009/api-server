package io.common.apiserver.service;

import io.common.apiserver.dao.MenuDao;
import io.common.apiserver.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project：api-server
 * @description：MenuService
 * @author：five.liu
 * @creat_time：2018年05月14日16:59
 */
@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> findByParentId(Long id) {
        return menuDao.findByParentId(id);
    }
}
