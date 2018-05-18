package io.common.apiserver.service;

import com.google.common.collect.Lists;
import io.common.apiserver.dao.UserDao;
import io.common.apiserver.dao.UserRoleDao;
import io.common.apiserver.entity.User;
import io.common.apiserver.entity.UserRole;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserRoleDao userRoleDao;

    @Transactional(rollbackFor = Exception.class)
    public User insert(User user) {
        User save = userDao.save(user);
        List<Long> roleIds = user.getRoleIds();
        if (roleIds != null && !roleIds.isEmpty()){
            insertUserRole(save.getId(), roleIds);
        }
        return save;
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

    @Transactional(rollbackFor = Exception.class)
    public void update(User user) {
        userRoleDao.deleteUserRoleByUserId(user.getId());
        List<Long> roleIds = user.getRoleIds();
        if (roleIds != null && !roleIds.isEmpty()){
           insertUserRole(user.getId(), roleIds);
        }
        userDao.save(user);
    }


    private void insertUserRole(Long userId, List<Long> roleIds){
        List<UserRole> userRoleList = new ArrayList<>(roleIds.size());
        for (Long roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);
        }
        userRoleDao.save(userRoleList);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
