package com.projeto.barbearia.DTO;

import com.projeto.barbearia.enums.RoleEnum;

import java.util.List;

public record UserCreateDTO(String name, String email, String password, RoleEnum role) {
}
