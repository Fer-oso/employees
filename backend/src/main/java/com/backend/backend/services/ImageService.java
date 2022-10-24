package com.backend.backend.services;

import com.backend.backend.entitys.Image;
import com.backend.backend.repository.ImageRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ImageService {

    private final ImageRepository imageRepository;
    private final UploadFileService uploadFileService;

    public ImageService(ImageRepository imageRepository, UploadFileService uploadFileService) {
        this.imageRepository = imageRepository;
        this.uploadFileService = uploadFileService;
    }

    public Image save(MultipartFile image) throws Exception {
        try {
            if (image.isEmpty()) {
                throw new Exception("you must select an image");
            } else {
                return imageRepository.save(new Image(uploadFileService.copy(image), image.getContentType()));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Image> findAll() throws Exception {
        if (!imageRepository.findAll().isEmpty()) {
            return imageRepository.findAll();
        } else {
            throw new Exception("no content");
        }
    }

    public String deleteById(int id) throws Exception {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return "image deleted successfully";
        } else {
            throw new Exception("image not found");
        }
    }

    public Image findById(int id) throws Exception {
        return imageRepository.findById(id).orElseThrow();
    }
    
    public Image setDefaultImageProfile()throws Exception{
        String name = "default.jpg";
        return imageRepository.findByName(name);
    }

}
