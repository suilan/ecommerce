package com.ssm.ecommerce.repo;

import com.ssm.ecommerce.model.Purchase;
import com.ssm.ecommerce.model.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
    Optional<Purchase> findPurchaseByCustomerId(Long customerId);

    Optional<Purchase> findPurchaseByIdAndPurchaseStatus(Long purchaseId, PurchaseStatus purchaseStatus);
}
