package io.common.apiserver.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.common.apiserver.dao.RoleDao;
import io.common.apiserver.dto.RoleDto;
import io.common.apiserver.entity.Role;
import io.common.apiserver.entity.User;
import io.common.apiserver.service.RoleService;
import io.common.apiserver.service.UserService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @project：api-server
 * @description：UserController
 * @author：five.liu
 * @creat_time：2018年05月15日13:44
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public R addUser(User user){
        user.setGmtCreate(new Date());
        user.setStatus(1);
        userService.insert(user);
        return R.ok();
    }

    @GetMapping("/list")
    public R list(@RequestParam int page, @RequestParam int size,
    @RequestParam(required = false) String username,
    @RequestParam(required = false) String mobile
    ){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<User> pageUtil = userService.getWhereClause(pageable,username,mobile);
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
    public R editUser(@RequestBody User user){
        user.setGmtModified(new Date());
        userService.update(user);
        return R.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public R deleteUser(@PathVariable String ids){
        userService.deleteByIds(ids);
        return R.ok();
    }
}
