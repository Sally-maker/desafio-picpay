package com.desafiopicpay.desafiopicpay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiopicpay.desafiopicpay.domain.User.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(Long id);
}
