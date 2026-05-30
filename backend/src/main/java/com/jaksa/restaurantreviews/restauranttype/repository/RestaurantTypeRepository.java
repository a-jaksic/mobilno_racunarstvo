package com.jaksa.restaurantreviews.restauranttype.repository;

import com.jaksa.restaurantreviews.restauranttype.domain.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Long> {

}
