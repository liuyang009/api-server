package io.common.apiserver.util;

import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * @project：api-server
 * @description：OssUtil
 * @author：five.liu
 * @creat_time：2018年05月24日15:14
 */
public class OssUtil {

    private static final String endpoint = "";
    private static final String accessKeyId = "";
    private static final String secretAccessKey = "";
    private static final String bucketName = "";

    private static final String url = "http://91shelves.oss-cn-qingdao.aliyuncs.com/";

    private final OSSClient client;

    private static OssUtil ossUtil = new OssUtil();

    private OssUtil(){
        client = new OSSClient(endpoint,
               accessKeyId,
                secretAccessKey);
    }

    public static OssUtil getInstance(){
        return ossUtil;
    }


    public String uploadFile(String key, byte[] bytes){
        client.putObject(bucketName, key, new ByteArrayInputStream(bytes));
        return url+key;
    }

    public String uploadFile(String key, File file){
        client.putObject(bucketName, key, file);
        return url+key;
    }
}
