package com.johncnstn.userservice.controller;

import com.johncnstn.userservice.dto.OrderDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    public static final String USER_SERVICE = "userService";

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @GetMapping("/displayOrders")
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public List<OrderDTO> displayOrders(@RequestParam(value = "category", required = false) String category) {
        String url = (category == null || category.isBlank())
                ? BASE_URL
                : BASE_URL + "/" + category;

        /*
            restTemplate.getForObject(url, ArrayList.class); fails with the:
                Could not write JSON: Cannot cast java.util.LinkedHashMap to com.johncnstn.userservice.dto.OrderDTO
            reason:
                Forces deserialization into a raw ArrayList
                → elements become LinkedHashMap
                → Spring later can’t treat them as OrderDTO.
         */
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                }
        );

        return response.getBody();
    }

    /*
    	1.	Have the same return type
	    2.	Have the same parameters as the original method
	    3.	Optionally have one additional last parameter of type Throwable

	    Throwable instead of Exception because the circuit breaker can propagate any failure, not just Exception.
     */
    public List<OrderDTO> getAllAvailableProducts(Throwable t) {
        return List.of(
                new OrderDTO(119L, "LED TV", "electronics", "white", 45000),
                new OrderDTO(345L, "Headset", "electronics", "black", 7000),
                new OrderDTO(475L, "Sound bar", "electronics", "black", 13000),
                new OrderDTO(574L, "Puma Shoes", "foot wear", "black & white", 4600),
                new OrderDTO(678L, "Vegetable chopper", "kitchen", "blue", 999),
                new OrderDTO(532L, "Oven Gloves", "kitchen", "gray", 745)

        );
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
