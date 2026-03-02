package com.johncnstn.simple_tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DevDataSeed {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Bean
    ApplicationRunner seed() {
        return args -> {
            User user = userRepository.save(new User()); // no id passed

            user.addOrder(new Order());
            user.addOrder(new Order());

            userRepository.save(user); // cascade persists orders
        };
    }

}
