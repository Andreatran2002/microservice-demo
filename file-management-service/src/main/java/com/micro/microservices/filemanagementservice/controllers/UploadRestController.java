package com.micro.microservices.filemanagementservice.controllers;


import com.micro.microservices.filemanagementservice.Enum.FILETYPE;
import com.micro.microservices.filemanagementservice.ultil.FileResolver;
import jakarta.servlet.ServletContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/file-management")
public class UploadRestController implements ServletContextAware {
    private ServletContext servletContext ;

    @PostMapping("upload")
    public ResponseEntity<Void> upload(@RequestParam MultipartFile[] files){
        try{
            for (MultipartFile file : files){
                String fileName = save(file);

                System.out.println(fileName);

            }


            return new ResponseEntity<Void>(HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    private String save(MultipartFile file){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
            String newFileName = simpleDateFormat.format(new Date()) + file.getOriginalFilename();

            byte[] bytes = file.getBytes();
            FILETYPE filetype = FileResolver.getType(file.getContentType());
            Path path = FileResolver.getPath(filetype,this.servletContext);

            Files.write(path,bytes);
            return newFileName;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
