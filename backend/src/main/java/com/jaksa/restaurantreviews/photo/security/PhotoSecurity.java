package com.jaksa.restaurantreviews.photo.security;

import com.jaksa.restaurantreviews.photo.domain.Photo;
import com.jaksa.restaurantreviews.photo.repository.PhotoRepository;
import com.jaksa.restaurantreviews.review.domain.Review;
import com.jaksa.restaurantreviews.review.repository.ReviewRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component("photoSecurity")
public class PhotoSecurity {

    private final PhotoRepository photoRepository;
    private final ReviewRepository reviewRepository;

    public PhotoSecurity(PhotoRepository photoRepository, ReviewRepository reviewRepository){
        this.photoRepository = photoRepository;
        this.reviewRepository = reviewRepository;
    }

    public boolean isReviewOwner(Long id, Authentication authentication){
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return false;
        }
        return review.getUser().getUsername().equals(authentication.getName());
    }

    public boolean isPhotoOwner(Long id, Authentication authentication){
        Photo photo = photoRepository.findById(id).orElse(null);
        if (photo == null){
            return  false;
        }
        if (photo.getReview() != null){
            return  photo.getReview().getUser().getUsername().equals(authentication.getName());
        }
        return false;
    }
}
