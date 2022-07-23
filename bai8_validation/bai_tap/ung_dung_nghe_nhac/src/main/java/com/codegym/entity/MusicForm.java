package com.codegym.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicForm {
    @Size(max = 800)
    @NotEmpty
    @Pattern(regexp = "^[^@;,=.-]*$", message = "{ky-tu-dac-biet}")
    private String name;
    @Size(max = 300)
    @NotEmpty
    @Pattern(regexp = "^[^@^;,=.-]*$", message = "{ky-tu-dac-biet}")
    private String singerName;
    @Size(max = 1000)
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9,]*$")
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
