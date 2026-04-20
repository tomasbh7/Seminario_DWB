package com.product.config.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
       		return new OpenAPI()
           			.info(new Info()
             .title("DWB - API Customer")
             .version("0.0.1")
             .description("API para la gestión clientes para la tienda en línea FCiencias Store."));
   	}
}
