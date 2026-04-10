package com.product.api.dto;

import jakarta.validation.constraints.NotNull;

public class DtoCategoryIn {

    @NotNull(message = "La categoría no puede ser nula")
    private String category;

    @NotNull(message = "El tag no puede ser nulo")
    private String tag;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}