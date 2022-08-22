package com.codegym.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Bạn chưa nhập Tiêu đề")
    @Size(max = 50, message = "tiêu đề không quá 50 ký tự")
    private String title;
    @NotEmpty(message = "Bạn chưa nhập nội dung")
    @Size(max = 500, message = "Nội dung không quá 500 ký tự")
    private String content;
    @NotNull(message = "Bạn chưa nhập ngày")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @NotEmpty(message = "Bạn chưa nhập phóng viên")
    private String reporter;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull(message = "Bạn chưa nhập Danh mục")
    private Category category;

    public News() {
    }

    public News(Integer id, String title, String content, Date startDate, String reporter) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.reporter = reporter;
    }

    public News(String title, String content, Date startDate, String reporter) {
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.reporter = reporter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
