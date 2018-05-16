package io.common.apiserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @project：api-server
 * @description：RoleMenuDto
 * @author：five.liu
 * @creat_time：2018年05月16日14:10
 */
@Data
public class RoleMenuDto {

    private Long roleId;

    private List<Long> menuIds;
}
