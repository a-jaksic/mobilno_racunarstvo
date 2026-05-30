package com.jaksa.restaurantreviews.workday.repository;

import com.jaksa.restaurantreviews.workday.domain.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {

    List<WorkDay> findByRestaurantId(Long id);
}
