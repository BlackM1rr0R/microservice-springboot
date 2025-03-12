package com.example.photosservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageDataService imageDataService;
    @PostMapping
    public ResponseEntity<?> uploadImages(@RequestParam("images") MultipartFile[] files) throws IOException {
        List<ImageUploadResponse> responses = new ArrayList<>();
        for (MultipartFile file : files) {
            ImageUploadResponse response = imageDataService.uploadImage(file);
            responses.add(response);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }
    @GetMapping("/info/{name}")
    public ResponseEntity<List<ImageData>> getImageInfoByName(@PathVariable("name") String name) {
        List<ImageData> images = imageDataService.getInfoByImageByName(name);
        return ResponseEntity.ok(images);
    }


    @GetMapping("/upload")
    public String showUploadPage() {
        return "upload";
    }

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> getImageByName(@PathVariable("name") String name) {
        List<ImageData> images = imageDataService.getInfoByImageByName(name);
        if (images.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ImageData imageData = images.get(0); // İlk resmi al
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(imageData.getType()))
                .body(imageData.getImageData());
    }



}
