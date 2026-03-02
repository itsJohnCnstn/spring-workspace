package com.johncnstn.simple_tasks;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

}
