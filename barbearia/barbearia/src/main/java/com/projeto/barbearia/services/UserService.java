package com.projeto.barbearia.services;

import com.projeto.barbearia.DTO.UserCreateDTO;
import com.projeto.barbearia.DTO.UserLoginDTO;
import com.projeto.barbearia.configs.SecurityConfig;
import com.projeto.barbearia.entities.Role;
import com.projeto.barbearia.entities.User;
import com.projeto.barbearia.entities.UserDetailsImpl;
import com.projeto.barbearia.enums.RoleEnum;
import com.projeto.barbearia.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final SecurityConfig securityConfig;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    public String authenticateUser(UserLoginDTO userLoginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.password());

        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return this.jwtTokenService.generateToken(userDetails);
    }

    public User createUser(UserCreateDTO userCreateDTO) {
        User user = User.builder()
                .name(userCreateDTO.name())
                .email(userCreateDTO.email())
                .password(this.securityConfig.passwordEncoder().encode(userCreateDTO.password()))
                .roles(List.of(Role.builder().name(userCreateDTO.role()).build()))
                .status(true)
                .salario(1500.00)
                .build();

        return this.userRepository.save(user);
    }
}
