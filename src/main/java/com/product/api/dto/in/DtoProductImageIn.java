package com.product.api.dto.in;

import jakarta.validation.constraints.NotNull;

public class DtoProductImageIn {

    @NotNull
    private Integer productId;

    @NotNull
    private String url;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}