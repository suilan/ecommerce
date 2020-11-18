package com.ssm.ecommerce.repo;

import com.ssm.ecommerce.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
    List<Contact> findContactByCustomerId(Long customerId);
}
