package com.ssm.ecommerce.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor // Lowbok
@Api(value = "Home - E-commerce")
@RequestMapping("home")
public class HomeController {
    @GetMapping
    public HashMap<String,String> home(){
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("Test","OK");
            return response;
    }
}
