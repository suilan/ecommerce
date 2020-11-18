package com.ssm.ecommerce.service;

import com.ssm.ecommerce.model.User;
import com.ssm.ecommerce.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> search(){
        return userRepo.findAll();
    }
}
