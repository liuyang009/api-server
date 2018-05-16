package io.common.apiserver.controller;

import com.google.common.collect.Maps;
import io.common.apiserver.annotation.Login;
import io.common.apiserver.dto.RoleMenuDto;
import io.common.apiserver.entity.Menu;
import io.common.apiserver.entity.Role;
import io.common.apiserver.service.MenuService;
import io.common.apiserver.service.RoleService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private MenuService menuService;

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


    @Login
    @DeleteMapping("/delete/{id}")
    @ApiOperation("列表")
    public R deleteRole(@PathVariable Long id){
        roleService.delete(id);
        return R.ok();
    }

    @Login
    @GetMapping("/menu/{roleId}")
    @ApiOperation("获取角色菜单")
    public R menuByRole(@PathVariable Long roleId){
        List<Menu> menuList = menuService.findByParentId(null);
        List<Long> mIds = menuService.findByRoleId(roleId);
        Map<String,Object> params = Maps.newHashMap();
        params.put("menus", menuList);
        params.put("mids", mIds);

        return R.ok(params);
    }

    @Login
    @PutMapping("basic/menu")
    public R updateRoleMenu(@RequestBody RoleMenuDto dto){

        roleService.updateRoleMenus(dto);

        return R.ok();
    }
}
