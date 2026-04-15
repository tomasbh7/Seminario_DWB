package com.product.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.in.DtoProductIn;
import com.product.api.dto.out.DtoProductListOut;
import com.product.api.dto.out.DtoProductOut;

public interface SvcProduct {

	public ResponseEntity<List<DtoProductListOut>> getProducts();
	public ResponseEntity<DtoProductOut> getProduct(Integer id);
	public ResponseEntity<String> createProduct(DtoProductIn in);
	public ResponseEntity<String> updateProduct(Integer id, DtoProductIn in);
	public ResponseEntity<String> enableProduct(Integer id);
	public ResponseEntity<String> disableProduct(Integer id);

}
