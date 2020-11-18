package com.ssm.ecommerce.dto;

import com.ssm.ecommerce.model.Product;
import com.ssm.ecommerce.model.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTO {
    private Product product;
    private List<ProductImage> productImages;
}
