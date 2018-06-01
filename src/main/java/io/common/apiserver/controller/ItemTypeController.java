package io.common.apiserver.controller;

import io.common.apiserver.annotation.Login;
import io.common.apiserver.entity.ItemType;
import io.common.apiserver.service.ItemTypeService;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ：five.liu
 * @project ：api-server
 * @description ：ItemTypeController
 * @create ：2018年06月01日15:59
 */
@RestController
@RequestMapping("/api/typeItem")
@Api(tags = "商品分类接口")
public class ItemTypeController extends BaseController{

    @Autowired
    private ItemTypeService itemTypeService;

    @Login
    @PostMapping("add")
    @ApiOperation("新增渠道")
    public R add(ItemType itemType){
        String name = itemType.getName();
        ItemType tt = itemTypeService.findByName(name);
        if (tt != null){
            return R.error("商品分类已存在，请勿重复添加");
        }
        itemType.setCreateTime(new Date());
        itemType.setCreateUser(getUsername());
        itemTypeService.save(itemType);
        return R.ok();
    }


    @Login
    @PutMapping("update")
    @ApiOperation("修改渠道")
    public R update(@RequestBody ItemType itemType){
        String name = itemType.getName();
        ItemType tt = itemTypeService.findByName(name);
        if (tt != null && !tt.getId().equals(itemType.getId())){
            return R.error("商品分类已存在，请勿重复添加");
        }
        itemTypeService.save(itemType);
        return R.ok();
    }

    @Login
    @DeleteMapping("/delete/{ids}")
    public R delete(@PathVariable String ids){
        itemTypeService.deleteByIds(ids);
        return R.ok();
    }

    @Login
    @GetMapping("/list")
    public R list(@RequestParam int page, @RequestParam int size,
                  @RequestParam(required = false) String name
    ){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<ItemType> pageList = itemTypeService.getWhereClause(pageable,name);
        return R.ok().put("data", pageList);
    }

}
