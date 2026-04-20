package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class CtrlProductImage {

    @Autowired
    private SvcProductImage service;

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImages(@PathVariable Integer id) {
        return service.getImagesByProduct(id);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<String> register(
            @PathVariable Integer id,
            @Valid @RequestBody DtoProductImageIn in) {

        return service.registerImage(id, in);
    }

    @DeleteMapping("/{id}/image/{imageId}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id,
            @PathVariable Integer imageId) {

        return service.deleteImage(id, imageId);
    }
}