package io.common.apiserver.service;

import io.common.apiserver.dao.ItemTypeDao;
import io.common.apiserver.entity.ItemType;
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
 * @author ：five.liu
 * @project ：api-server
 * @description ：ItemTypeService
 * @create ：2018年06月01日15:58
 */
@Service
public class ItemTypeService {

    @Autowired
    private ItemTypeDao itemTypeDao;

    public ItemType findByName(String name) {
        return itemTypeDao.findByName(name);
    }

    public void save(ItemType itemType) {
        itemTypeDao.save(itemType);
    }

    public Page<ItemType> getWhereClause(Pageable pageable, String name) {
        return itemTypeDao.findAll(
                (root, query, cb) -> {
                    List<Predicate> predicateList = new ArrayList<>();
                    if (!StringUtils.isEmpty(name)) {
                        Path<String> namePath = root.get("name");
                        predicateList.add(cb.like(namePath, "%"+name+"%"));
                    }
                    Predicate[] predicates = new Predicate[predicateList.size()];
                    predicateList.toArray(predicates);
                    query.where(predicates);
                    return null;
                }, pageable
        );
    }

    public void deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        for (String s : idArr) {
            this.delete(Long.parseLong(s));
        }
    }
    private void delete(long id) {
        itemTypeDao.delete(id);
    }
}
