package com.ssm.ecommerce.service;
import com.ssm.ecommerce.dto.CustomerDTO;
import com.ssm.ecommerce.model.Customer;
import com.ssm.ecommerce.repo.AddressRepo;
import com.ssm.ecommerce.repo.ContactRepo;
import com.ssm.ecommerce.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final ContactRepo contactRepo;
    private final AddressRepo addressRepo;

    public List<Customer> search(){
        return customerRepo.findAll();
    }

    public CustomerDTO find(Long id) {
        CustomerDTO customerDTO;

        Optional<Customer> customer = customerRepo.findById(id);

        if(customer.isEmpty()) throw new ServiceException("Customer not found");

        customerDTO = new CustomerDTO(customer.get());
        customerDTO.setContacts(contactRepo.findContactByCustomerId(customer.get().getId()));
        customerDTO.setAddresses(addressRepo.findAddressByCustomerId(customer.get().getId()));

        return customerDTO;
    }


}
