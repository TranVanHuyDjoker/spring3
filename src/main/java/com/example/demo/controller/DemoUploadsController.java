package com.example.demo.controller;
// uploadfile
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class DemoUploadsController {
//    @Value("${config.upload_folder}")
//    String UPLOAD_FOLDER;


    @GetMapping("/upload-form")
    public String uploadFrom(){
        return "upload-form";
    }

    @PostMapping("/do-upload-file")
    public String douploadFile(@RequestParam(name="image")MultipartFile file){

//        String path = "C:/Users/nhattam/Desktop/spring_upl/" + file.getOriginalFilename();
//        try {
//            Files.write(Paths.get(path), file.getBytes());
//        } catch (Exception e){
//            System.out.println("cannot upload");
//            e.printStackTrace();
//        }

        String rootpath = "C:/Users/nhattam/Desktop/spring_upl/";
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();//2021
        int month = localDate.getMonthValue();//12
        String subFolder = month+"_"+year+"/";//12_2021/
        String fullUploadDir = rootpath + subFolder;
        File checkDir = new File(fullUploadDir);
        if (!checkDir.exists() || checkDir.isFile()) {
            //tạo mới folder
            checkDir.mkdir();
        }
        try {
            Files.write(Paths.get(fullUploadDir+ Instant.now().getEpochSecond() +file.getOriginalFilename()), file.getBytes());
        } catch (Exception e) {
            System.out.println("cannot upload file");
            e.printStackTrace();
        }


        return "redirect:/upload-form";
    }
}
