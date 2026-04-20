package com.product.api.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @JsonProperty("id")
    private Integer categoryId;

    @Column(name = "category", nullable = false, unique = true, length = 50)
    @JsonProperty("category")
    private String category;

    @Column(name = "tag", nullable = false, unique = true, length = 50)
    @JsonProperty("tag")
    private String tag;

    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private Integer status;

    public Category() {}

    public Category(Integer categoryId, String category, String tag, Integer status) {
        this.categoryId = categoryId;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}