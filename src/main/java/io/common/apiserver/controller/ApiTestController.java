package io.common.apiserver.controller;

import io.common.apiserver.config.OssProperties;
import io.common.apiserver.util.OssUtil;
import io.common.apiserver.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 测试接口
 *
 * @author five.liu
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
public class ApiTestController extends BaseController{

    @Autowired
    OssProperties ossProperties;

    private final static String[] acceptFileType = {"jpg", "png", "bmp", "gif", "jpeg"};

    @PostMapping("upload")
    public R upload(MultipartFile file){
       try {
           String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
           File dir = new File(uploadDir);
           if (!dir.exists()){
               dir.mkdir();
           }
           String filename = file.getOriginalFilename();
           File serverFile = new File(uploadDir + filename);
           file.transferTo(serverFile);
           return R.ok().put("url", uploadDir + filename);
       }catch (Exception e){
           e.printStackTrace();
       }
      return R.error("上传失败");
    }


    @PostMapping("upload2")
    public R upload2(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return R.error("文件不能为空");
        }
        String filename = file.getOriginalFilename();
        String type = filename.split("\\.")[1];
        boolean accept = false;
        for (String x:acceptFileType){
            if (type.equals(x)){
                accept = true;
            }
        }
        if (!accept){
            return R.error("不允许的文件类型");
        }
        String url =  OssUtil.getInstance().uploadFile(UUID.randomUUID()+"."+type, file.getBytes());
        return R.ok().put("url", url);
    }

    @GetMapping("test")
    public R test(){

        return R.ok().put("v", ossProperties.getBucketName());
    }
}
