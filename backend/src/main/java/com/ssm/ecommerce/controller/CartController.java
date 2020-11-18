package com.ssm.ecommerce.controller;

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
@Api(value = "Purchase - E-commerce")
@RequestMapping("cart")
@CrossOrigin(origins = "*")

/**
 * Controller to manipulate shopping cart
 */
public class CartController {

    private final PurchaseService purchaseService;

    /**
     * Get Shopping Cart by purchase id
      * @param purchaseId
     * @return Returns the shopping cart
     */
    @GetMapping("/{purchaseId}")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Purchase> getShoppingCart(@PathVariable Long purchaseId){
        return ResponseEntity.ok(purchaseService.findShoppingCartById(purchaseId));
    }

    /**
     * Register the product in the shopping cart
     * @param purchaseId
     * @param purchaseProducts
     * @return The newly inserted products
     */
    @PostMapping("/{purchaseId}/product")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<PurchaseProduct>> setPurchaseProduct(@PathVariable Long purchaseId, @RequestBody List<PurchaseProduct> purchaseProducts){
        return ResponseEntity.ok(purchaseService.saveProducts(purchaseId,purchaseProducts));
    }

    /**
     * Delete from shopping cart all products sended
     * @param purchaseId
     * @param purchaseProducts
     * @return Returns an empty list if succeds
     */
    @DeleteMapping("/{purchaseId}/product")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> removeProductsFromCart(@PathVariable Long purchaseId, @RequestBody List<PurchaseProduct> purchaseProducts){
        purchaseService.removeProductsFromCart(purchaseId,purchaseProducts);
        return ResponseEntity.noContent().build();
    }

    /**
     * Send customer to the checkout process
     * @param purchaseId The id of the customer to find the shopping cart
     */
    @PostMapping("/{purchaseId}/checkout")
    public ResponseEntity<?> startCheckout(@PathVariable Long purchaseId) {
        purchaseService.startCheckout(purchaseId);
        return ResponseEntity.noContent().build();
    }
}
