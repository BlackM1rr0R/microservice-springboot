package com.example.photosservice;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imageData")
@Data
@Getter
@Setter
@AllArgsConstructor
public class ImageData {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
    public ImageData() {
        // Parametresiz yapıcıyı elle ekleyebiliriz
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    // Builder inner class
    public static class Builder {
        private Long id;
        private String name;
        private String type;
        private byte[] imageData;

        // Builder metodları
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder imageData(byte[] imageData) {
            this.imageData = imageData;
            return this;
        }

        // Builder metodu ile oluşturma
        public ImageData build() {
            // Parametresiz yapıcıyı kullanalım
            ImageData imageDataObj = new ImageData();
            imageDataObj.id = this.id;
            imageDataObj.name = this.name;
            imageDataObj.type = this.type;
            imageDataObj.imageData = this.imageData;
            return imageDataObj;
        }
    }
}
