package com.jaksa.restaurantreviews.security.dtos;

public record MobileJwtResponse(
        String accessToken,
        String refreshToken)
{}
