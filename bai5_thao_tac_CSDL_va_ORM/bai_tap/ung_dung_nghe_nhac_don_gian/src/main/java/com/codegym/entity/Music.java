package com.codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @Column(name = "music_name", columnDefinition = "varchar(100)")
    private String name;
    private String singerName;
    private String category;
    private String filePath;

    public Music() {
    }

    public Music(String name, String singerName, String category, String filePath) {
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", singerName='" + singerName + '\'' +
                ", category='" + category + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
