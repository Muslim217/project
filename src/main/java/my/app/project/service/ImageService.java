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

    public byte[] get(long id){
        Image image = repository.findById(id).get();
        return image.getBytes();
    }

    public void delete(long id){
        Image image = repository.findById(id).get();
        repository.delete(image);
    }

    public void patch(long id, MultipartFile file) throws IOException {
        Image image = repository.findById(id).get();
        image.setBytes(file.getBytes());
        image.setFileName(file.getOriginalFilename());
        repository.save(image);
    }
}
