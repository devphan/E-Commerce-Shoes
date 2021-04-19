package com.ecommerce.shoes.controller.api;

import com.ecommerce.shoes.entity.UploadForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
public class ApiUploadFile {
//    private static String UPLOAD_DIR = System.getProperty("user.home") + "/upload";
    private static String UPLOAD_DIR = "E:\\E-commerce project\\Git repo\\e-commerce-shoes\\src\\main\\resources\\static\\image\\upload";


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute UploadForm uploadForm) {
        //Tạo folder lưu ảnh
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        System.out.println(UPLOAD_DIR);
        MultipartFile fileData = uploadForm.getFileData();
        String nameFile = fileData.getOriginalFilename();
        if (nameFile != null && nameFile.length() > 0) {
            try {
                //Tạo file
                File serverFile = new File(UPLOAD_DIR + "/" + nameFile);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                stream.close();
                return ResponseEntity.ok(nameFile);

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when uploading");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}
