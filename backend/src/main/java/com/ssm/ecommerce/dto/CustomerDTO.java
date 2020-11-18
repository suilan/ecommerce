package com.ssm.ecommerce.dto;

import com.ssm.ecommerce.model.Address;
import com.ssm.ecommerce.model.Contact;
import com.ssm.ecommerce.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private byte active;
    private Date birthday;
    private String cpf;
    private Timestamp createdAt;
    private String fullname;
    private short gender;
    private String rg;
    private Timestamp updatedAt;

    private List<Contact> contacts;
    private List<Address> addresses;

    public CustomerDTO(Customer customer){
        this.id = customer.getId();
        this.active = customer.getActive();
        this.birthday = customer.getBirthday();
        this.cpf = customer.getCpf();
        this.createdAt = customer.getCreatedAt();
        this.fullname = customer.getFullname();
        this.gender = customer.getGender();
        this.rg = customer.getRg();
        this.updatedAt = customer.getUpdatedAt();
    }

}
