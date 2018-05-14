package io.common.apiserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @project：api-server
 * @description：MenuMeta 配置
 * @author：five.liu
 * @creat_time：2018年05月14日14:52
 */
public class MenuMeta {

    private boolean keepAlive;
    private boolean requireAuth;

}
