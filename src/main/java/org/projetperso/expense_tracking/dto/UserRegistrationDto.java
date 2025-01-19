package org.projetperso.expense_tracking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
}

