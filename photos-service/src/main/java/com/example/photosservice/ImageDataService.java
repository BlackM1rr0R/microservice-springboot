package com.example.photosservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageDataService {
    @Autowired
    private ImageDataRepository imageDataRepository;

    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = new ImageData.Builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .build();

        imageDataRepository.save(imageData);
        return new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename());
    }

    public List<ImageData> getInfoByImageByName(String name) {
        List<ImageData> images = imageDataRepository.findByName(name);
        return images.stream()
                .map(image -> new ImageData.Builder()
                        .name(image.getName())
                        .type(image.getType())
                        .imageData(ImageUtil.decompressImage(image.getImageData()))
                        .build())
                .toList();
    }

    public byte[] getImage(String name) {
        List<ImageData> images = imageDataRepository.findByName(name);
        if (images.isEmpty()) {
            return null;
        }
        return ImageUtil.decompressImage(images.get(0).getImageData());
    }
}

