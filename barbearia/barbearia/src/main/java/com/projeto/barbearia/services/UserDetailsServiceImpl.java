package com.projeto.barbearia.services;

import com.projeto.barbearia.entities.UserDetailsImpl;
import com.projeto.barbearia.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDetailsImpl.builder()
                .user(user)
                .build();
    }
}
