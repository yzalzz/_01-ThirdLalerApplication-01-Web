package com.fc.service.impl;

import com.fc.service.UploadService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public ResultVo upload(MultipartFile file, String type) {
        ResultVo resultVo=null;
        // 准备路径
        String path = "http://localhost:8081/upload/";

        // 获取文件名
        String filename =file.getOriginalFilename();



        // 获取后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String format = formatter.format(new Date());

        // 拼接成一个新的文件名
        filename = format + suffix;

        if (filename != null) {
            Client client = Client.create();
            // 连接服务器
            WebResource resource = client.resource(path + filename);
            // 推送文件到服务器上
            try {
                resource.put(file.getBytes());
                resultVo = new ResultVo(200, "查询成功", true,  path+filename );
            } catch (IOException e) {
                e.printStackTrace();
            }
                System.out.println(resultVo);
            } else {
                resultVo = new ResultVo(400, "查询失败", false, null);
            }
        return resultVo;
        }
    }












//
//        ResultVo resultVo = null;
//        String path = "D:/tomcat/server/apache-tomcat-8.5.37/webapps/upload";
//        File files = new File(path);
//        //文件上传路径为空
//        if (!files.exists()) {
//            files.mkdirs();
//        }
//        //获取文件名
//        String originalFilename = file.getOriginalFilename();
//        try {
//            if (originalFilename != null) {
//                //上传文件
//                file.transferTo(new File(path, originalFilename));
//                resultVo = new ResultVo(200, "查询成功", true,  "http://localhost:8081/upload"+"/"+ originalFilename);
//                System.out.println(resultVo);
//            } else {
//                resultVo = new ResultVo(400, "查询失败", false, null);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultVo;
//    }





