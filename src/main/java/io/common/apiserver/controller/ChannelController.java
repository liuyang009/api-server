package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.Channel;
import io.common.apiserver.service.ChannelService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：ChannelController
 * @create ：2018年06月01日13:13
 */
@RestController
@RequestMapping("/api/channel")
@Api(tags = "渠道接口")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @Login
    @PostMapping("add")
    @ApiOperation("新增渠道")
    public R add(Channel channel){
        String name = channel.getName();
        Channel c = channelService.findByName(name);
        if (c != null){
            return R.error("渠道已存在，请勿重复添加");
        }
        channelService.save(channel);
        return R.ok();
    }

    @Login
    @PutMapping("update")
    @ApiOperation("更新渠道")
    public R update(@RequestBody Channel channel){
        String name = channel.getName();
        Channel c = channelService.findByName(name);
        if (c != null && !c.getId().equals(channel.getId())){
            return R.error("渠道已存在，请勿重复添加");
        }
        channelService.save(channel);
        return R.ok();
    }

    @Login
    @GetMapping("/list")
    public R list(@RequestParam int page, @RequestParam int size,
                  @RequestParam(required = false) String name,
                  @RequestParam(required = false) String status
    ){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<Channel> pageUtil = channelService.getWhereClause(pageable,name,status);
        return R.ok().put("data", pageUtil);
    }


    @Login
    @DeleteMapping("/delete/{ids}")
    public R delete(@PathVariable String ids){
        channelService.deleteByIds(ids);
        return R.ok();
    }

}
