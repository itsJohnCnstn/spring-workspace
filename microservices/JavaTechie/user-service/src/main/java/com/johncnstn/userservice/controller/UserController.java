package com.johncnstn.userservice.controller;

import com.johncnstn.userservice.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private static final String BASE_URL = "http://localhost:9191/orders";

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @GetMapping("/displayOrders")
    public List<OrderDTO> displayOrders(@RequestParam(value = "category", required = false) String category) {
        String url = (category == null || category.isBlank())
                ? BASE_URL
                : BASE_URL + "/" + category;

        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                }
        );

        return response.getBody();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
