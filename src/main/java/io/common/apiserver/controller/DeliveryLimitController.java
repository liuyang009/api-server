package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.Channel;
import io.common.apiserver.entity.DeliveryLimit;
import io.common.apiserver.service.DeliveryLimitService;
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
 * @description ：DeliveryLimitController
 * @create ：2018年06月03日8:57
 */
@RestController
@RequestMapping("/api/delivery")
@Api(tags = "提货限制接口")
public class DeliveryLimitController extends BaseController{

    @Autowired
    private DeliveryLimitService deliveryLimitService;


    @Login
    @PostMapping("add")
    @ApiOperation("新增提货限制")
    public R add(@RequestBody DeliveryLimit limit){
        limit.setCreateUser(getUsername());
        limit.setStatus(1);
        deliveryLimitService.save(limit);
        return R.ok();
    }


    @Login
    @GetMapping("/list")
    public R list(@RequestParam int page, @RequestParam int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<DeliveryLimit> pageUtil = deliveryLimitService.getPage(pageable);
        return R.ok().put("data", pageUtil);
    }

}
