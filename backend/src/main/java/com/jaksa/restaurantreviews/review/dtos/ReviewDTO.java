package com.jaksa.restaurantreviews.review.dtos;

import java.time.LocalDateTime;

public record ReviewDTO(
        Long id,

        String username,

        Integer rating,

        String title,

        LocalDateTime createdAt
) {}
