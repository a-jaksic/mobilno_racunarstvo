package com.jaksa.restaurantreviews.review.security;

import com.jaksa.restaurantreviews.review.domain.Review;
import com.jaksa.restaurantreviews.review.repository.ReviewRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("reviewSecurity")
public class ReviewSecurity {

    private final ReviewRepository reviewRepository;

    public ReviewSecurity(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public boolean isReviewOwner(Long id, Authentication authentication){
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            return false;
        }
        return review.getUser().getUsername().equals(authentication.getName());
    }
}
