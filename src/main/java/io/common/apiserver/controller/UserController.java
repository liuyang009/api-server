package io.common.apiserver.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.common.apiserver.annotation.Login;
import io.common.apiserver.dto.PasswordDto;
import io.common.apiserver.dto.RoleDto;
import io.common.apiserver.entity.Menu;
import io.common.apiserver.entity.Role;
import io.common.apiserver.entity.User;
import io.common.apiserver.service.MenuService;
import io.common.apiserver.service.RoleService;
import io.common.apiserver.service.UserService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @project：api-server
 * @description：UserController
 * @author：five.liu
 * @creat_time：2018年05月15日13:44
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户接口")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;


    @Login
    @PostMapping("/add")
    public R addUser(User user){
        user.setGmtCreate(new Date());
        user.setStatus(1);
        userService.insert(user);
        return R.ok();
    }

    @Login
    @GetMapping("/list")
    public R list(@RequestParam int page, @RequestParam int size,
    @RequestParam(required = false) String username,
    @RequestParam(required = false) String mobile
    ){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<User> pageUtil = userService.getWhereClause(pageable,username,mobile);
        List<User> content = pageUtil.getContent();
        if (!content.isEmpty()){
            content.stream().forEach(user -> {
                user.setRoleIds(roleService.findByUserId(user.getId()));
            });
        }
        List<RoleDto> list = Lists.newArrayList();
        List<Role> roleList = roleService.findAll();
        if (roleList != null && !roleList.isEmpty()){
            for (Role role : roleList) {
                RoleDto dto = new RoleDto();
                dto.setValue(role.getId());
                dto.setLabel(role.getNameZh());
                list.add(dto);
            }
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("data", pageUtil);
        params.put("roles", list);
        return R.ok(params);
    }

    @PutMapping("/edit")
    @Login
    public R editUser(@RequestBody User user){
        user.setGmtModified(new Date());
        userService.update(user);
        return R.ok();
    }

    @Login
    @DeleteMapping("/delete/{ids}")
    public R deleteUser(@PathVariable String ids){
        userService.deleteByIds(ids);
        return R.ok();
    }


    @Login
    @GetMapping("/menu")
    @ApiOperation("用户权限菜单")
    public R sysMenu() {
        List<Menu> first = Lists.newArrayList();
        List<Menu> menuList = userService.listMenus(getUsername());
        if (menuList != null && !menuList.isEmpty()){
            List<Long> ids = menuList.stream().map(Menu::getParentId).collect(Collectors.toList());
            List<Long> distinctIds = ids.stream()
                    .distinct()
                    .collect(Collectors.toList());
            for (Long distinctId : distinctIds) {
                List<Menu> second = Lists.newArrayList();
                for (Menu menu : menuList) {
                    if (Objects.equals(menu.getParentId(), distinctId)){
                        second.add(menu);
                    }
                }
                Menu m = menuService.findOne(distinctId);
                m.setChildren(second);
                first.add(m);
            }
        }
        Collections.sort(first, Comparator.comparing(Menu::getOrderNum));
        return R.ok().put("data", first);
    }

    @Login
    @PostMapping("/updatePwd")
    @ApiOperation("修改密码")
    public R updatePwd(PasswordDto dto){

        String username = getUsername();
        User user = userService.findByUsername(username);
        if (user == null){
            return R.error("用户不存在");
        }
        user.setPassword(dto.getPassword());
        userService.save(user);
        return R.ok();
    }

}
