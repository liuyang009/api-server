package io.common.apiserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @project：api-server
 * @description：OssProperties
 * @author：five.liu
 * @creat_time：2018年05月24日15:23
 */
@Component
@ConfigurationProperties(prefix = "my.oss")
@Data
public class OssProperties {

    private String accessKeyId;

    private String ossAddress;

    private String accessKeySecret;

    private String bucketName;

    private String filePath;

}
