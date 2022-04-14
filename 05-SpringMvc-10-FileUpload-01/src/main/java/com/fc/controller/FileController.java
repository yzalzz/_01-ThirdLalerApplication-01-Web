package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    //MultipartFile file SpringMvc对文件上传封装 代表上传文件
    public ModelAndView upload(MultipartFile upload,ModelAndView mv)  {
        //准备文件上传路径
        String path="D:/tomcat/server/apache-tomcat-8.5.37/webapps";
        File file = new File(path);
        //如果路径不存在
        if (!file.exists()){
            //创建一个
            file.mkdirs();
        }
        //获取文件名
        String filename = upload.getOriginalFilename();
        try {
            if (filename != null) {
                //上传
                upload.transferTo(new File(file,filename));
                mv.addObject("img","http://localhost:8081/upload/"+filename);
                mv.setViewName("/success.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mv;

    }
}
