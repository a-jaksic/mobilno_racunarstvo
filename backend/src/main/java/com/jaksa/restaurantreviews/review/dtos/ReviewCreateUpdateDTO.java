package com.jaksa.restaurantreviews.review.dtos;

public record ReviewCreateUpdateDTO(
        Integer rating,

        String title,

        String description
)
{}
