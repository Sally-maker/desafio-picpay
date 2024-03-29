package com.desafiopicpay.desafiopicpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiopicpay.desafiopicpay.domain.User.User;

public interface TransactionRepository extends JpaRepository<User, Long> {
    
}
