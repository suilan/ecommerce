package com.ssm.ecommerce.controller;


import com.ssm.ecommerce.dto.ProductImageDTO;
import com.ssm.ecommerce.model.Product;
import com.ssm.ecommerce.model.User;
import com.ssm.ecommerce.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // Lowbok
@Api(value = "Product - E-commerce")
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Product>> search(){
        return ResponseEntity.ok(productService.search());
    }
}
