package io.common.apiserver.dto;

import lombok.Data;

/**
 * 项目 ：api-server
 * 描述 ：PasswordDto
 * 作者 ：five.liu
 * 创建时间 ：2018年05月30日15:30
 */
@Data
public class PasswordDto {

    private String password;

    private String checkPass;
}
