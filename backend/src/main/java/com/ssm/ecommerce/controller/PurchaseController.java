package com.ssm.ecommerce.controller;

import com.ssm.ecommerce.dto.ProductImageDTO;
import com.ssm.ecommerce.model.Customer;
import com.ssm.ecommerce.model.Purchase;
import com.ssm.ecommerce.service.CustomerService;
import com.ssm.ecommerce.service.ProductService;
import com.ssm.ecommerce.service.PurchaseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // Lowbok
@Api(value = "Purchase - E-commerce")
@RequestMapping("purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final CustomerService customerService;

}
