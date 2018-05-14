package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.Role;
import io.common.apiserver.service.RoleService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project：api-server
 * @description：RoleController
 * @author：five.liu
 * @creat_time：2018年05月14日18:48
 */
@RestController
@RequestMapping("/api/role")
@Api(tags = "角色接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Login
    @PostMapping("/add")
    @ApiOperation("新增")
    public R addRole(@RequestParam String name, @RequestParam String nameZh){
        Role role = new Role();
        role.setName(name);
        role.setNameZh(nameZh);
        roleService.save(role);
        return R.ok();
    }

    @Login
    @GetMapping("/list")
    @ApiOperation("列表")
    public R listRole(){
        List<Role> roles = roleService.findAll();
        return R.ok().put("roles", roles);
    }
}
