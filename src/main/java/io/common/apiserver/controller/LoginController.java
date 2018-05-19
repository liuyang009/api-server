package io.common.apiserver.controller;

import io.common.apiserver.entity.User;
import io.common.apiserver.service.UserService;
import io.common.apiserver.util.JWTUtils;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @project：api-server
 * @description：LoginController
 * @author：five.liu
 * @creat_time：2018年05月18日13:48
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录接口")
public class LoginController extends BaseController{

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public R login(@RequestParam("username") String username
            , @RequestParam("password") String password){

        User user = userService.findByUsername(username);
        if (user == null || !password.equals(user.getPassword())){
            return R.error("用户名或密码错误");
        }
        Map<String, Object> map = JWTUtils.sign(username, secret);
        map.put("username", username);

        return R.ok().put("data", map);
    }

}
