package com.backend.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

    final Path rutaCarpeta = Paths.get("uploads");

      public String copy(MultipartFile file) throws IOException {
       String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
       Files.copy(file.getInputStream(),rutaCarpeta.resolve(uniqueFilename));
       return uniqueFilename;
    }
}