package com.ssm.ecommerce.service;

import com.ssm.ecommerce.config.PurchaseStatusValue;
import com.ssm.ecommerce.model.*;
import com.ssm.ecommerce.repo.CustomerRepo;
import com.ssm.ecommerce.repo.ProductRepo;
import com.ssm.ecommerce.repo.PurchaseProductRepo;
import com.ssm.ecommerce.repo.PurchaseRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepo purchaseRepo;
    private final CustomerRepo customerRepo;
    private final PurchaseProductRepo purchaseProductRepo;
    private final ProductRepo productRepo;

    /**
     * Search the Purchase by the id
     * @param purchaseId
     * @return Returns the object select or throw an error if it doesn't exists
     */
    public Purchase search(Long purchaseId){
        Optional<Purchase> purchase = purchaseRepo.findById(purchaseId);
        if(purchase.isEmpty()){
            throw new ServiceException("Order not found");
        }
        return purchase.get();
    }

    /**
     * Save the purchase with the products related to it
     * @param customerId
     * @param purchaseProducts
     * @return Return the new object
     */
    @Transactional
    public Purchase save(Long customerId, List<PurchaseProduct> purchaseProducts){
        Purchase purchaseNew = new Purchase();
        PurchaseStatus purchaseStatus = new PurchaseStatus();

        // Set 1-ShoppingCart
        purchaseStatus.setId(PurchaseStatusValue.SHOPPING_CART);

        // Check if the customer exists
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()){

            // Set Customer
            purchaseNew.setCustomer(customer.get());
            // Set Status
            purchaseNew.setPurchaseStatus(purchaseStatus);
            Purchase savedPurchase = purchaseRepo.save(purchaseNew);

            // Register the products
            for (PurchaseProduct newPurchaseProduct: purchaseProducts) {
                newPurchaseProduct.setPurchaseId(savedPurchase.getId());
                purchaseProductRepo.save(newPurchaseProduct);
            }

        } else {
            throw new ServiceException("Customer not found");
        }
        return purchaseNew;
    }

    /**
     * Search the purchase by the customer id
     * @param customerId The customer id to be searched
     * @return Returns the purchase object or throws an error
     */
    public Purchase findByCustomerId(Long customerId){
        Optional<Purchase> purchase = purchaseRepo.findPurchaseByCustomerId(customerId);
        if(purchase.isEmpty()){
            throw new ServiceException("Order not found");
        }
        return purchase.get();
    }

    /**
     * Find customer shopping cart
     * @param purchaseId The customer id to be searched
     * @return Returns a pruchase or throws an error
     */
    public Purchase findShoppingCartById(Long purchaseId){
        Optional<Purchase> shoppingCart = purchaseRepo.findPurchaseByIdAndPurchaseStatus(purchaseId,new PurchaseStatus(PurchaseStatusValue.SHOPPING_CART));
        if(shoppingCart.isEmpty()){
            throw new ServiceException("Order not found");
        }
        return shoppingCart.get();
    }

    /**
     * Save a list os new products
     * @param purchaseId The purchase id to be searched
     * @param newPurchaseProducts The list of new products
     * @return Returns the list of saved products
     */
    public List<PurchaseProduct> saveProducts(Long purchaseId, List<PurchaseProduct> newPurchaseProducts){
        // Register the products
        List<PurchaseProduct> savedPurchaseProducts = new ArrayList<>();
        for (PurchaseProduct newPurchaseProduct: newPurchaseProducts) {
            newPurchaseProduct.setPurchaseId(purchaseId);
            savedPurchaseProducts.add(purchaseProductRepo.save(newPurchaseProduct));
        }
        return savedPurchaseProducts;
    }

    /**
     * Method to remove the product from the purchase list (only Shopping Cart)
     * @param purchaseId The purchase being searched.
     * @param purchaseProducts The products to be removerd from the purchase
     * @return An empty product list.
     */
    public List<PurchaseProduct> removeProductsFromCart(Long purchaseId, List<PurchaseProduct> purchaseProducts){
        // Remove all products in the list
        purchaseProductRepo.deleteAll(purchaseProducts);

        // Remove all elements
        purchaseProducts.clear();

        // Return an empty list
        return purchaseProducts;
    }

    /**
     * Change Purchase Status
     * @param purchaseId
     * @return Return success or exception
     */
    public boolean startCheckout(Long purchaseId){
        boolean response= false;
        Optional<Purchase> purchase = purchaseRepo.findPurchaseByIdAndPurchaseStatus(purchaseId,new PurchaseStatus(PurchaseStatusValue.SHOPPING_CART));

        if(purchase.isPresent()){
            purchase.get().setPurchaseStatus(new PurchaseStatus(PurchaseStatusValue.CHECKOUT));
            purchaseRepo.save(purchase.get());
            response=true;
        }
        else throw new ServiceException("Shopping Cart not found");

        return response;
    }
}
