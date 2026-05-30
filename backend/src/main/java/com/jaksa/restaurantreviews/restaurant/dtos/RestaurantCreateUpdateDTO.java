package com.jaksa.restaurantreviews.restaurant.dtos;

public record RestaurantCreateUpdateDTO(
        String name,

        String address,

        Double latitude,

        Double longitude,

        String phoneNum,

        String website,

        Long cityId,

        Long restaurantTypeId
)
{}
