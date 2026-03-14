package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class SvcCategoryImplementacion implements SvcCategory {

    @Autowired
    private RepoCategory repoCategory;

    @Override
    public ResponseEntity<List<Category>> getCategories() {

        try {

            List<Category> categories = repoCategory.getCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);

        } catch (DataAccessException e) {

            throw new ApiException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error al consultar las categorías en la base de datos"
            );

        }

    }
}