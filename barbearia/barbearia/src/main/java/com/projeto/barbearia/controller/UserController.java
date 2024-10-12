package com.projeto.barbearia.controller;

import com.projeto.barbearia.DTO.UserCreateDTO;
import com.projeto.barbearia.DTO.UserLoginDTO;
import com.projeto.barbearia.entities.User;
import com.projeto.barbearia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> authenticated() {
        return ResponseEntity.ok("Você está autenticado");
    }

    @GetMapping("/test/customer")
    public ResponseEntity<String> authenticatedCustomer() {
        return ResponseEntity.ok("Você está autenticado como customer");
    }

    @GetMapping("/test/barbeiro")
    public ResponseEntity<String> authenticatedBarbeiro() {
        return ResponseEntity.ok("Você está autenticado como barbeiro");
    }

    @GetMapping("/test/gerente")
    public ResponseEntity<String> authenticatedGerente() {
        return ResponseEntity.ok("Você está autenticado como gerente");
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(this.userService.authenticateUser(userLoginDTO));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(this.userService.createUser(userCreateDTO));
    }
}
