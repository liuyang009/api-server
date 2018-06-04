package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.DeliveryLimit;
import io.common.apiserver.service.DeliveryLimitService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R add(DeliveryLimit limit){
        limit.setCreateUser(getUsername());
        deliveryLimitService.save(limit);
        return R.ok();
    }

}
