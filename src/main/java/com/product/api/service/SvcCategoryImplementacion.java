package com.product.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

import org.springframework.dao.DataAccessException;
import com.product.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import com.product.api.dto.DtoCategoryIn;

@Service
public class SvcCategoryImplementacion implements SvcCategory {

    @Autowired
    private RepoCategory repoCategory;

    @Override
    public List<Category> findAll() {
        try {
            return repoCategory.findAll();
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al obtener las categorías");
        }
    }

    @Override
    public List<Category> findActive() {
        try {
            return repoCategory.findByStatus(1);
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al obtener las categorías activas");
        }
    }

 
    @Override
    public void create(DtoCategoryIn in) {
        try {
            if (repoCategory.existsByCategory(in.getCategory())) {
                throw new ApiException(HttpStatus.BAD_REQUEST,
                        "La categoría ya existe");
            }

            if (repoCategory.existsByTag(in.getTag())) {
                throw new ApiException(HttpStatus.BAD_REQUEST,
                        "El tag ya existe");
            }

            Category category = new Category();
            category.setCategory(in.getCategory());
            category.setTag(in.getTag());
            category.setStatus(1);

            repoCategory.save(category);

        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar la categoría");
        }
    }

   
    @Override
    public void update(DtoCategoryIn in, Integer id) {
        try {
            Optional<Category> optional = repoCategory.findById(id);

            if (!optional.isPresent()) {
                throw new ApiException(HttpStatus.NOT_FOUND,
                        "Categoría no encontrada");
            }
            Category category = optional.get();

            if (repoCategory.existsByCategoryAndCategoryIdNot(in.getCategory(), id)) {
                throw new ApiException(HttpStatus.BAD_REQUEST,
                        "La categoría ya existe");
            }

            if (repoCategory.existsByCategoryAndCategoryIdNot(in.getTag(), id)) {
                throw new ApiException(HttpStatus.BAD_REQUEST,
                        "El tag ya existe");
            }

            category.setCategory(in.getCategory());
            category.setTag(in.getTag());

            repoCategory.save(category);

        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al actualizar la categoría");
        }
    }
    @Override
    public void enable(Integer id) {
        try {
            Category category = repoCategory.findById(id)
                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                            "Categoría no encontrada"));

            category.setStatus(1);
            repoCategory.save(category);

        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al activar la categoría");
        }
    }

    @Override
    public void disable(Integer id) {
        try {
            Category category = repoCategory.findById(id)
                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                            "Categoría no encontrada"));

            category.setStatus(0);
            repoCategory.save(category);

        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al desactivar la categoría");
        }
    }
}