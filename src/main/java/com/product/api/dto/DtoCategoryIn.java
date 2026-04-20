package com.product.api.dto;

import com.product.api.dto.DtoCategoryIn;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class DtoCategoryIn {

    @NotBlank(message = "El campo category no puede ser nulo")
    private String category;

    @NotBlank(message = "El campo tag no puede ser nulo")
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