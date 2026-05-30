package com.jaksa.restaurantreviews.review.dtos;

import java.time.LocalDateTime;

public record ReviewDetailsDTO(

        Long id,

        String username,

        Integer rating,

        String title,

        String description,

        LocalDateTime createdAt

) {}
