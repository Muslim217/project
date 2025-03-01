package my.app.project.service;

import my.app.project.model.Image;
import my.app.project.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    public void save(MultipartFile file) throws IOException {
        Image image = new Image();

        System.out.println("Все работает");
        image.setFileName(file.getOriginalFilename());
        image.setBytes(file.getBytes());
        repository.save(image);
    }
}
