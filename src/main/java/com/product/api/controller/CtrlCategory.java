package com.product.api.controller;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.api.dto.DtoCategoryIn;


@RestController
@RequestMapping("/api")
public class CtrlCategory {

	@Autowired
    private SvcCategory svcCategory;

    @GetMapping("/category")
    public List<Category> findAll() {
        return svcCategory.findAll();
    }


    @GetMapping("/category/active")
    public List<Category> findActive() {
        return svcCategory.findActive();
    }


    @PostMapping("/category")
    public String create(@RequestBody DtoCategoryIn in) {
        svcCategory.create(in);
        return "La categoría ha sido registrada";
    }

    @PutMapping("/category/{id}")
    public String update(@RequestBody DtoCategoryIn in,
                         @PathVariable Integer id) {
        svcCategory.update(in, id);
        return "La categoría ha sido actualizada";
    }

 
    @PatchMapping("/category/{id}/enable")
    public String enable(@PathVariable Integer id) {
        svcCategory.enable(id);
        return "La categoría ha sido activada";
    }

    @PatchMapping("/category/{id}/disable")
    public String disable(@PathVariable Integer id) {
        svcCategory.disable(id);
        return "La categoría ha sido desactivada";
    }
}