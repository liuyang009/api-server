package io.common.apiserver.controller;

import io.common.apiserver.entity.Menu;
import io.common.apiserver.entity.MenuMeta;
import io.common.apiserver.util.JWTUtils;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping("login")
    @ApiOperation("忽略Token验证测试")
    public R Login(@RequestParam("username") String username, @RequestParam("password") String password){
        return R.ok().put("token", JWTUtils.sign(username,"test").get("token"));
    }

    @GetMapping("/menu")
    @ApiOperation("系统菜单")
    public R sysMenu() {
        List<Menu> menuList = new ArrayList<>(1);
        List<Menu> childList = new ArrayList<>(1);
        Menu childMenu = new Menu();
        childMenu.setPath("/shop/basic");
        childMenu.setComponent("ShopBasic");
        childMenu.setName("用户管理");
        childMenu.setMeta(new MenuMeta(false, true));
        childList.add(childMenu);

        Menu menu = new Menu();
        menu.setId(2L);
        menu.setPath("/home");
        menu.setComponent("Home");
        menu.setName("系统信息");
        menu.setIconCls("el-icon-location-outline");
        menu.setChildren(childList);
        menu.setMeta(new MenuMeta(false, true));
        menuList.add(menu);

        return R.ok().put("data", menuList);
    }
}
