package my.app.project.controller;

import my.app.project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable long id){
        try {
            byte[] imageBytes = service.get(id);
            if (imageBytes != null){
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG);
                return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable long id){
        try{
            if (getImage(id) != null){
                service.delete(id);
                return  new ResponseEntity<>("Удаление выполнено", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Отсутствует такой id", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка удаления из бд", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> patchImageById(@PathVariable long id, @RequestParam("image") MultipartFile file){
        try {
            service.patch(id, file);
            return new ResponseEntity<>("Изменения приняты", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Ошибка изменения в бд", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
