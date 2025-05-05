package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadControlleer {

   /* @PostMapping("/upload")
    public Result upload(Integer age, String name ,MultipartFile file) throws IOException {
        log.info("上传文件：{},{},{}",age,name,file.getOriginalFilename());

        String originalFilename = file.getOriginalFilename();
        String late = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString()+late;
        file.transferTo(new java.io.File("D:/DaoBanPC/images/"+newFileName));
        return Result.success();

    }*/
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}",file.getOriginalFilename());
        String originalFilename = file.getOriginalFilename();
        byte[] content = file.getBytes();
        String url = aliyunOSSOperator.upload(content, originalFilename);
        log.info("上传文件地址：{}",url);
        return Result.success(url);
    }
}
