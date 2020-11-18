package com.ssm.ecommerce.controller;

import com.ssm.ecommerce.dto.CustomerDTO;
import com.ssm.ecommerce.model.*;
import com.ssm.ecommerce.service.CustomerService;
import com.ssm.ecommerce.service.PurchaseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // Lowbok
@Api(value = "Customer - E-commerce")
@RequestMapping("customer")
/**
 * Controller to access customer data
 */
public class CustomerController {
    private final CustomerService customerService;
    private final PurchaseService purchaseService;

    /**
     * Get the customer data by id
     * @param customerId
     * @return The full purchase object
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> search(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.find(customerId));
    }

    /**
     * Get the customer data by id
     * @param customerId
     * @return The full purchase object
     */
    @GetMapping("/{customerId}/order")
    public ResponseEntity<Purchase> searchByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(purchaseService.findByCustomerId(customerId));
    }
}
