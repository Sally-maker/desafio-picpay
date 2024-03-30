package com.desafiopicpay.desafiopicpay.dtos;
import java.math.*;

import com.desafiopicpay.desafiopicpay.domain.User.UserType;

public record UserDTO(String firstName,  String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
    
}
