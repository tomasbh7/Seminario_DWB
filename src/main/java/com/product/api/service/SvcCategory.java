package com.product.api.service;
import org.springframework.http.ResponseEntity;

import java.util.List;
import com.product.api.entity.Category;

public interface SvcCategory {
	public ResponseEntity<List<Category>> getCategories();
}
