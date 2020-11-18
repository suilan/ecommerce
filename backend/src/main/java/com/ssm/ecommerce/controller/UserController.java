package com.ssm.ecommerce.controller;


import com.ssm.ecommerce.model.User;
import com.ssm.ecommerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor // Lowbok
@Api(value = "User - E-commerce")
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> buscar(){
        return ResponseEntity.ok(userService.search());
    }
}
