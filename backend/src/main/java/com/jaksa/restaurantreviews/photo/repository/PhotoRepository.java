package com.jaksa.restaurantreviews.photo.repository;

import com.jaksa.restaurantreviews.photo.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByReviewId(Long id);

    List<Photo> findByRestaurantId(Long id);
}
