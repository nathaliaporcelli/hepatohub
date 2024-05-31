package com.example.hepatohub.service;

import com.example.hepatohub.model.User;
import com.example.hepatohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        // Adicione verificação para evitar a criação de usuários duplicados, se necessário
        // Por exemplo:
        // if (userRepository.existsByUsername(user.getUsername())) {
        //     throw new IllegalArgumentException("Username already exists");
        // }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
