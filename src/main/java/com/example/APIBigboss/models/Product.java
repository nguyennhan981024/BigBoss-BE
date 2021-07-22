package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    private String status;
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cate_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(int id, String name, String status, String img, Category category) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.img = img;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
