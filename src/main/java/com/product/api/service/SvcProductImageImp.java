package com.product.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.Product;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProduct;
import com.product.api.repository.RepoProductImage;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;

@Service
public class SvcProductImageImp implements SvcProductImage {

    @Autowired
    private RepoProduct repoProduct;

    @Autowired
    private RepoProductImage repoImage;

    @Override
    public ResponseEntity<String> registerImage(Integer productId, DtoProductImageIn in) {
       try {
    	   Product product = repoProduct.findById(productId)
                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                            "El producto no existe"));

            ProductImage image = new ProductImage();
            image.setUrl(in.getUrl());
            image.setStatus(1);
            image.setProduct(product);

            repoImage.save(image);

            return new ResponseEntity<>("Imagen registrada correctamente", HttpStatus.CREATED);

        } catch (DataAccessException e) {
            throw new DBAccessException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al registrar la imagen");
        }
    }
    @Override
    public ResponseEntity<?> getImagesByProduct(Integer productId) {
        try {
            return ResponseEntity.ok(
                    repoImage.findByProductProduct_Id(productId)
            );
        } catch (DataAccessException e) {
            throw new DBAccessException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al obtener imágenes");
        }
    }

    @Override
    public ResponseEntity<String> deleteImage(Integer productId, Integer imageId) {
        try {
            ProductImage image = repoImage.findById(imageId)
                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                            "La imagen no existe"));

            if (!image.getProduct().getId().equals(productId)) {
                throw new ApiException(HttpStatus.BAD_REQUEST,
                        "La imagen no pertenece al producto");
            }

            repoImage.delete(image);

            return ResponseEntity.ok("La imagen ha sido eliminada");

        } catch (DataAccessException e) {
            throw new DBAccessException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al eliminar la imagen");
        }
    }
}