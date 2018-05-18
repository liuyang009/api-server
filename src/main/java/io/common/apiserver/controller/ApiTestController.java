package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.service.MenuService;
import io.common.apiserver.util.JWTUtils;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试接口
 *
 * @author five.liu
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
public class ApiTestController {

    @Autowired
    private MenuService menuService;


    @Login
    @GetMapping("/menu")
    @ApiOperation("系统菜单")
    public R sysMenu() {

        Long roleId = 3L;
        List<Long> menuIds = menuService.findByRoleId(roleId);

        return R.ok().put("data", menuService.findByParentId(1L));
    }

}
