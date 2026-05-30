package com.jaksa.restaurantreviews.photo.mapper;

import com.jaksa.restaurantreviews.photo.domain.Photo;
import com.jaksa.restaurantreviews.photo.dtos.PhotoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PhotoMapper {

    Photo toEntity(PhotoDTO photoDTO);

    PhotoDTO toDTO(Photo photo);
}
