package io.common.apiserver.controller;

import com.google.common.collect.Lists;
import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.Role;
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

    @PostMapping("login")
    @ApiOperation("忽略Token验证测试")
    public R Login(@RequestParam("username") String username, @RequestParam("password") String password){
       // return R.error("用户名或密码错误");
        return R.ok().put("token", JWTUtils.sign(username,"test").get("token"));
    }

    @Login
    @GetMapping("/menu")
    @ApiOperation("系统菜单")
    public R sysMenu() {
        return R.ok().put("data", menuService.findByParentId(1L));
    }

    @Login
    @GetMapping("/roles")
    @ApiOperation("系统角色")
    public R sysRole() {
        List<Role> list = Lists.newArrayList();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_manager");
        role.setNameZh("超级管理员");
        list.add(role);
        return R.ok().put("data", list);
    }
}
