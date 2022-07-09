package com.codegym.entity;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private String name;
    private String singerName;
    private String category;
    private MultipartFile filePath;

    public MusicForm() {
    }

    public MusicForm(String name, String singerName, String category, MultipartFile filePath) {
        this.name = name;
        this.singerName = singerName;
        this.category = category;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }
}
