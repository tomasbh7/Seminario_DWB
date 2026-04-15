package com.product.api.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.product.api.entity.ProductImage;

public interface RepoProductImage extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findByProductId(Integer productId);
}