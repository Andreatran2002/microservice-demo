package com.micro.microservices.filemanagementservice.ultil;

import com.micro.microservices.filemanagementservice.Enum.FILETYPE;
import jakarta.servlet.ServletContext;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileResolver {
    public static FILETYPE getType(String contentType){
        switch (contentType){
            case "application/msword":
                return FILETYPE.WORD;
            case "application/pdf":
                return FILETYPE.PDF;
            case "images/png":
            case "images/jpeg":
            case "images/gif":
                return FILETYPE.IMAGE;

            default:
                return FILETYPE.OTHERS;

        }
    }
    public static Path getPath(FILETYPE fileType, ServletContext servletContext){

        switch (fileType){
            case WORD:
                return Paths.get(servletContext.getRealPath("/uploads/word/"));
            case PDF:
               return Paths.get(servletContext.getRealPath("/uploads/pdf/"));
            case IMAGE:
                return Paths.get(servletContext.getRealPath("/uploads/image/"));

            default:
                return Paths.get(servletContext.getRealPath("/uploads/others/"));


        }
    }

}
