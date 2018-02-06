package com.pengkey.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fileUpLoadManage")
public class FileUpLoadManageController {
    @Value("${file.upload.dir}")
    private String downFileDir;

}
