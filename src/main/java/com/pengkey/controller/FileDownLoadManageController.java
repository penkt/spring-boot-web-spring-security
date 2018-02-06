package com.pengkey.controller;

import com.pengkey.request.FileInfoRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Maps;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/fileDownManage")
public class FileDownLoadManageController {
    @Value("${file.download.dir}")
    private String downFileDir;

    @RequestMapping(value = "/download/{fileId}")
    public void downFileByFiileId(FileInfoRequest request){


    }

    @RequestMapping(value = "/download/test",method = {RequestMethod.GET,RequestMethod.POST})
    public void downFileTest(HttpServletResponse response)throws Exception{

        File file=new File(downFileDir+"test.txt");
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=test.txt" );
        try {
            InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
            OutputStream outputStream=response.getOutputStream();
            byte[] bytes=new byte[2048];
            int i=inputStream.read(bytes);
            while (i!=-1){
                outputStream.write(bytes);
                outputStream.flush();
                i=inputStream.read(bytes);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
