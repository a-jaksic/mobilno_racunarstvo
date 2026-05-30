package com.jaksa.restaurantreviews.review.repository;

import com.jaksa.restaurantreviews.review.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRestaurantIdAndUserUsername(Long restaurantId, String username);

    Page<Review> findByRestaurantIdAndUserUsernameNot(Long restaurantId, String currentUsername, Pageable pageable);

}
