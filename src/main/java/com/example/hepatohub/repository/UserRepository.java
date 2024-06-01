package com.example.hepatohub.repository;

import com.example.hepatohub.model.User; // Importando a classe User do pacote model
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}