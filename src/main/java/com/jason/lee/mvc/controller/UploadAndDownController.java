package com.jason.lee.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: Json Lee
 * @Date: 2020/10/28 11:16 PM
 */
@Controller
public class UploadAndDownController {


    @RequestMapping(value = "/down")
    public ResponseEntity<byte[]> down(HttpSession session) throws Exception{
        String realPath = session.getServletContext().getRealPath("image");
        String finalPath = realPath + File.separator + "xmu.jpg";
        InputStream in = new FileInputStream(finalPath);
        // available() 获取输入流所读取的文件的最大字节数
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=xmu.jpg");
        HttpStatus status = HttpStatus.OK;
        in.close();
        ResponseEntity<byte[]> entity = new ResponseEntity<>(bytes,headers,status);
        return entity;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(String desc, MultipartFile uploadFile, HttpSession session) {
        try {
            String fileName = uploadFile.getOriginalFilename();
            String path = session.getServletContext().getRealPath("/file") + File.separator + fileName;
            InputStream in = uploadFile.getInputStream();
            File file = new File(path);
            // 保存方式一
            uploadFile.transferTo(file);
            // 保存方式二
//            OutputStream out = new FileOutputStream(file);
//            int i = 0;
//            while ((i=in.read())!=-1){
//                out.write(i);
//            }
//            out.close();
//            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}














