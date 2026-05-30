package com.jaksa.restaurantreviews.user.dtos;

import com.jaksa.restaurantreviews.user.domain.Role;

public record UserResponseDTO(

        Long id,

        String username,

        String email,

        Role role
)
{}
