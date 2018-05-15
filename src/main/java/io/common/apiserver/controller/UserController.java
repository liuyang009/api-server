package io.common.apiserver.controller;

import io.common.apiserver.entity.User;
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

    @PostMapping("/add")
    public R addUser(User user){
        user.setGmtCreate(new Date());
        userService.save(user);
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
        return R.ok().put("data", pageUtil);
    }

    @PutMapping("/edit")
    public R editUser(@RequestBody User user){
        user.setGmtModified(new Date());
        userService.save(user);
        return R.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public R deleteUser(@PathVariable String ids){
        userService.deleteByIds(ids);
        return R.ok();
    }
}
