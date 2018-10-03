package ru.napadovskiu.entities;


import javax.persistence.*;

public class Images {

    private int imageId;

    private String imagePath;

    public Images() {
    }

    public Images(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
