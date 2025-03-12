package com.example.photosservice;


import lombok.Data;


@Data
public class ImageUploadResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    public ImageUploadResponse(String message) {
        this.message = message;
    }
    public ImageUploadResponse(){

    }
}
