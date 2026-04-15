package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product-image")
public class CtrlProductImage {

    @Autowired
    private SvcProductImage service;

    @PostMapping
    public ResponseEntity<String> register(@Valid @RequestBody DtoProductImageIn in) {
        return service.registerImage(in);
    }
}