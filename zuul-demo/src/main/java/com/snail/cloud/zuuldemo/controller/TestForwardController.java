package com.snail.cloud.zuuldemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/16 9:25
 */
@RestController
@Slf4j
public class TestForwardController {

    @GetMapping("/home/{path}")
    public String home(@PathVariable("path") String path){
        return "forward "+path;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {

        File targetFile=new File("D:\\upload\\"+file.getOriginalFilename());
        if(!targetFile.getParentFile().exists()){
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        String filePath=targetFile.getAbsolutePath();
        log.info("{}",filePath);
        return filePath;
    }

}
