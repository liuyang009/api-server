package io.common.apiserver.dao;

import io.common.apiserver.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：ChannelDao
 * @create ：2018年06月01日13:12
 */
public interface ChannelDao extends JpaRepository<Channel, Long>,JpaSpecificationExecutor<Channel> {
    /**
     *  查询
     * @param name
     * @return
     */
    Channel findByName(String name);
}
