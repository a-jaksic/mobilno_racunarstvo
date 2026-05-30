package com.jaksa.restaurantreviews.restaurant.mapper;

import com.jaksa.restaurantreviews.restaurant.domain.Restaurant;
import com.jaksa.restaurantreviews.restaurant.dtos.RestaurantCreateUpdateDTO;
import com.jaksa.restaurantreviews.restaurant.dtos.RestaurantDTO;
import com.jaksa.restaurantreviews.restaurant.dtos.RestaurantDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RestaurantMapper {

    Restaurant toEntity(RestaurantDTO restaurantDTO);

    Restaurant toEntity(RestaurantCreateUpdateDTO restaurantCreateUpdateDTO);

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "restaurantType.name", target = "typeName")
    RestaurantDTO toDTO(Restaurant restaurant);

    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "restaurantType.id", target = "restaurantTypeId")
    RestaurantDetailsDTO toDetailsDTO(Restaurant restaurant);

    void updateEntityFromUpdateDto(RestaurantCreateUpdateDTO restaurantCreateUpdateDTO, @MappingTarget Restaurant restaurant);
}
