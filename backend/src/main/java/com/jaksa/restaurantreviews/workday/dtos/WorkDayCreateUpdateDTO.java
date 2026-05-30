package com.jaksa.restaurantreviews.workday.dtos;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record WorkDayCreateUpdateDTO(
        LocalTime openTime,

        LocalTime closeTime,

        DayOfWeek day
) {}
