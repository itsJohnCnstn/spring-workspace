package com.johncnstn.simple_tasks;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUser(userId);
        List<Order> orders = user.getOrders();
        System.out.println("initialized? " + Hibernate.isInitialized(user.getOrders()));
        return ResponseEntity.ok(orders);
    }

}
