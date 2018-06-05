package com.xhj.controller;


import com.xhj.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 熊厚谨 on 2018/5/31 15:01
 *
 * @author 熊厚谨
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "C:\\Users\\XHJ\\IdeaProjects\\security\\security-demo\\src\\main\\java\\com\\xhj\\securitydemo\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            //将文件写入到response中,当有http请求成功的时候将会返回带文件的响应
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            //使用commit.io包中的copy方法，inputStream中的内容复制到outputStream
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        }
    }
}
