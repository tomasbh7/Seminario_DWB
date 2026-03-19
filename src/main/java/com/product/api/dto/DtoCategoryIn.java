package com.product.api.dto;
import jakarta.validation.constraints.NotBlank;

public class DtoCategoryIn {

	@NotBlank(message = "El campo category no puede ser nulo")
    private String category;

	@NotBlank(message = "El campo tag no puede ser nulo")
    private String tag;
}
