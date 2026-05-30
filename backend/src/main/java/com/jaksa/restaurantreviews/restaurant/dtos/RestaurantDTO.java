package com.jaksa.restaurantreviews.restaurant.dtos;

public record RestaurantDTO(
        Long id,

        String name,

        String cityName,

        String typeName,

        Double avgRating,

        String address,

        String phoneNum,

        String website
)
{}
