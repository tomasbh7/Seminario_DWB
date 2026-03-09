package com.product.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class SvcCategoryImplementacion implements SvcCategory {

    @Autowired
    private RepoCategory repoCategory;

    @Override
    public ResponseEntity<List<Category>> getCategories() {

        List<Category> categories = repoCategory.getCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
