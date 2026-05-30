package com.jaksa.restaurantreviews.user.dtos;

import com.jaksa.restaurantreviews.user.domain.Role;

public record UserUpdateDTO(

        String username,

        String email,

        String currentPassword,

        String newPassword
)
{}
