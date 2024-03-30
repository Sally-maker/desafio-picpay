package com.desafiopicpay.desafiopicpay.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiopicpay.desafiopicpay.domain.User.User;
import com.desafiopicpay.desafiopicpay.domain.User.UserType;
import com.desafiopicpay.desafiopicpay.dtos.UserDTO;
import com.desafiopicpay.desafiopicpay.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista não está autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.repository.save(newUser);
        return newUser;
    }

    public List<User> getAllUser(){
        return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
