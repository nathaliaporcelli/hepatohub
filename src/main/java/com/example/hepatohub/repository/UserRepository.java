package com.example.hepatohub.repository;

import com.example.hepatohub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

}
