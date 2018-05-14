package io.common.apiserver.controller;

import io.common.apiserver.entity.Menu;
import io.common.apiserver.entity.MenuMeta;
import io.common.apiserver.service.MenuService;
import io.common.apiserver.util.JWTUtils;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("login")
    @ApiOperation("忽略Token验证测试")
    public R Login(@RequestParam("username") String username, @RequestParam("password") String password){
        return R.ok().put("token", JWTUtils.sign(username,"test").get("token"));
    }

    @GetMapping("/menu")
    @ApiOperation("系统菜单")
    public R sysMenu() {
        return R.ok().put("data", menuService.findByParentId(null));
    }
}
