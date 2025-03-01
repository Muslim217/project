package my.app.project.controller;

import my.app.project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService service;

    @PostMapping
    public ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile file){
        if(file.isEmpty()){
            return new ResponseEntity<>("Запрос пустой", HttpStatus.NO_CONTENT);
        }

        try{
            service.save(file);
            return new ResponseEntity<>("Все круто записалось", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Ошибка записи в бд", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
