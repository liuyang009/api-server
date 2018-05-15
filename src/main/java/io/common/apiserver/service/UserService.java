package io.common.apiserver.service;

import io.common.apiserver.dao.UserDao;
import io.common.apiserver.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @project：api-server
 * @description：UserService
 * @author：five.liu
 * @creat_time：2018年05月15日13:43
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User save(User user) {
        return userDao.save(user);
    }

    public Page<User> getPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    public Page<User> getWhereClause(Pageable pageable, String username, String mobile) {
        return userDao.findAll(
                (root, query, cb) -> {
                    List<Predicate> predicateList = new ArrayList<>();
                    if (!StringUtils.isEmpty(username)) {
                        Path<String> username1 = root.get("username");
                        predicateList.add(cb.like(username1, "%"+username+"%"));
                    }
                    if (!StringUtils.isEmpty(mobile)) {
                        Path<String> phone = root.get("mobile");
                        predicateList.add(cb.like(phone, "%"+mobile+"%"));
                    }
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    predicateList.toArray(predicates);
                    query.where(predicates);
                    return null;
                }, pageable
        );
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public void deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        for (String s : idArr) {
            delete(Long.parseLong(s));
        }
    }
}
