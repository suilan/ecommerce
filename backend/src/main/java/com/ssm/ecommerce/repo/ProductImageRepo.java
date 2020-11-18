package com.ssm.ecommerce.repo;

import com.ssm.ecommerce.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
//    List<ProductImage> findProductImageByProductId(Long productId);
}
