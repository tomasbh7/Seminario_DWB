package com.product.api.service;

import org.springframework.http.ResponseEntity;
import com.product.api.dto.in.DtoProductImageIn;

public interface SvcProductImage {

	ResponseEntity<String> registerImage(Integer productId, DtoProductImageIn in);

    ResponseEntity<?> getImagesByProduct(Integer productId);

    ResponseEntity<String> deleteImage(Integer productId, Integer imageId);
}