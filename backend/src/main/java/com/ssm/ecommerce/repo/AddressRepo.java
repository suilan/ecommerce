package com.ssm.ecommerce.repo;

import com.ssm.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
    List<Address> findAddressByCustomerId(Long customerId);
}
