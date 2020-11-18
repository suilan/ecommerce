package com.ssm.ecommerce.service;


import com.ssm.ecommerce.model.Product;
import com.ssm.ecommerce.repo.ProductImageRepo;
import com.ssm.ecommerce.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductImageRepo productImageRepo;

    // Get product with images
    public List<Product> search(){
        return productRepo.findAll();
    }
}
