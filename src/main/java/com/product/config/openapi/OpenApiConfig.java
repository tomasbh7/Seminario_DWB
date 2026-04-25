package com.product.config.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Schema;

import org.springdoc.core.customizers.OpenApiCustomizer;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DWB - API Product")
                        .version("1.0.0")
                        .description("API para la gestión de productos, categorías e imágenes."));
    }

    @Bean
    public OpenApiCustomizer sortSchemasAlphabetically() {
        return openApi -> {
            Components components = openApi.getComponents();

            if (components != null && components.getSchemas() != null) {
                Map<String, Schema> sortedSchemas =
                        components.getSchemas().entrySet().stream()
                                .sorted(Map.Entry.comparingByKey())
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new
                                ));

                components.setSchemas(sortedSchemas);
            }
        };
    }
}