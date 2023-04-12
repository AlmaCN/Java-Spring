package co.develhope.ServiziFileUpload.controllers;

import co.develhope.ServiziFileUpload.services.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ho creato una classe FileController e l'ho annotata con RestController.
 * Ho creato i due metodi per fare l'upload ed il download di una foto
 * ed ho fatto l'autowired di FileStorageService
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public List<String> upload(@RequestParam MultipartFile[] files){
        try{
            List<String> fileNames = new ArrayList<>();
            for(MultipartFile file : files){
                String singleUploadedFileName = fileStorageService.upload(file);
                fileNames.add(singleUploadedFileName);
            }
            return fileNames;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/download")
    public @ResponseBody byte[] download(@RequestParam String fileName, HttpServletResponse response){
        try{
            System.out.println("Downloading " + fileName);
            String extension = FilenameUtils.getExtension(fileName);
            switch (extension){
                case "gif":
                    response.setContentType(MediaType.IMAGE_GIF_VALUE);
                    break;
                case "jpg":
                case "jpeg":
                    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                    break;
                case "png":
                    response.setContentType(MediaType.IMAGE_PNG_VALUE);
                    break;
            }
            response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\"");
            return fileStorageService.download(fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
