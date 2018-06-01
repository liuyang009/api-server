package io.common.apiserver.service;

import io.common.apiserver.dao.ChannelDao;
import io.common.apiserver.entity.Channel;
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
 * @description ：ChannelService
 * @create ：2018年06月01日13:15
 */
@Service
public class ChannelService {

    @Autowired
    private ChannelDao channelDao;

    public Channel findByName(String name) {
        return channelDao.findByName(name);
    }

    public void save(Channel channel) {
        channelDao.save(channel);
    }

    public Page<Channel> getWhereClause(Pageable pageable, String name, String status) {
        return channelDao.findAll(
                (root, query, cb) -> {
                    List<Predicate> predicateList = new ArrayList<>();
                    if (!StringUtils.isEmpty(name)) {
                        Path<String> namePath = root.get("name");
                        predicateList.add(cb.like(namePath, "%"+name+"%"));
                    }
                    if (!StringUtils.isEmpty(status)) {
                        Path<String> statusPath = root.get("status");
                        predicateList.add(cb.equal(statusPath, status));
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
        channelDao.delete(id);
    }
}
