package com.jaksa.restaurantreviews.workday.dtos;

import com.jaksa.restaurantreviews.restaurant.domain.Restaurant;


import java.time.DayOfWeek;
import java.time.LocalTime;

public record WorkDayDTO(
    Long id,

    LocalTime openTime,

    LocalTime closeTime,

    DayOfWeek day
){}
