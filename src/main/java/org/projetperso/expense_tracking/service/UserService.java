package org.projetperso.expense_tracking.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.projetperso.expense_tracking.dto.UserRegistrationDto;
import org.projetperso.expense_tracking.dto.UserResponseDto;
import org.projetperso.expense_tracking.entity.Role;
import org.projetperso.expense_tracking.entity.User;
import org.projetperso.expense_tracking.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface UserService {
    UserResponseDto registerUser(UserRegistrationDto registrationDto);
    UserResponseDto getUserProfile(Long userId);
    UserResponseDto updateUser(Long userId, UserRegistrationDto userDto);
    void deleteUser(Long userId);
}

