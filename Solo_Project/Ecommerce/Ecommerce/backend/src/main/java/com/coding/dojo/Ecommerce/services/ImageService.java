package com.coding.dojo.Ecommerce.services;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageService {

	private final String uploadDir = "C:\\Users\\souro\\OneDrive\\Bureau\\Fullstack Courses\\Java_Stack\\Solo_Project\\Ecommerce\\images";

    public String saveImage(MultipartFile image) throws IOException {
        // Ensure the upload directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a unique file name to prevent overwriting
        String originalFileName = image.getOriginalFilename();
        //String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        //String newFileName = UUID.randomUUID().toString() + fileExtension;

        // Define the file path
        Path path = Paths.get(uploadDir + originalFileName);

        // Save the file to disk
        Files.write(path, image.getBytes());

        return originalFileName;
    }
}
