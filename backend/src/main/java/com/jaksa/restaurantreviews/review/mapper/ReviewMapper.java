package com.jaksa.restaurantreviews.review.mapper;

import com.jaksa.restaurantreviews.review.domain.Review;
import com.jaksa.restaurantreviews.review.dtos.ReviewCreateUpdateDTO;
import com.jaksa.restaurantreviews.review.dtos.ReviewDTO;
import com.jaksa.restaurantreviews.review.dtos.ReviewDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ReviewMapper {

    Review toEntity(ReviewDTO reviewDTO);

    Review toEntity(ReviewCreateUpdateDTO reviewCreateUpdateDTO);

    @Mapping(source = "user.username", target = "username")
    ReviewDTO toDTO(Review review);

    @Mapping(source = "user.username", target = "username")
    ReviewDetailsDTO toDetailsDTO(Review review);

    void updateEntityFromUpdateDto(ReviewCreateUpdateDTO reviewCreateUpdateDTO, @MappingTarget Review review);
}
