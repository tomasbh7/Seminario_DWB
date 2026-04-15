package com.product.api.service;

import org.springframework.http.ResponseEntity;
import com.product.api.dto.in.DtoProductImageIn;

public interface SvcProductImage {

    ResponseEntity<String> registerImage(DtoProductImageIn in);
}