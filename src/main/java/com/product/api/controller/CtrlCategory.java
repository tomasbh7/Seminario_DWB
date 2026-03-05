package com.product.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

@RestController
@RequestMapping("/api")
public class CtrlCategory {

    @Autowired
    private RepoCategory repo;

    @GetMapping("/category")
    public List<Category> getCategories(){
        return repo.getCategories();
    }
}