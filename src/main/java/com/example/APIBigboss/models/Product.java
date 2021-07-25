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
    private String cate_name;
    private int cate_id;
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(int id, String name, String status, String img, String cate_name, int cate_id, Category category) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.img = img;
        this.cate_name = cate_name;
        this.cate_id = cate_id;
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

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
