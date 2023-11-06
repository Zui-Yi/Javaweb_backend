package com.rx.controller;

import com.rx.pojo.Result;
import com.rx.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {


    /*@PostMapping
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传:{},{},{}",username,age,image);
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构造唯一的文件名（不能重复）-- uuid（通用唯一识别码）
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String uuid = UUID.randomUUID().toString();
        String newFileName=uuid+extname;
        //将文件存储在服务器的磁盘目录下
        image.transferTo(new File("D:\\"+newFileName));
        return Result.success();
    }*/

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传:{}",image.getOriginalFilename());

        //调用阿里云oss工具类
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url为:{}",url);

        return Result.success(url);
    }


}
