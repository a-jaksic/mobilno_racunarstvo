package com.jaksa.restaurantreviews.restauranttype.mapper;

import com.jaksa.restaurantreviews.restauranttype.domain.RestaurantType;
import com.jaksa.restaurantreviews.restauranttype.dtos.RestaurantTypeCreateDTO;
import com.jaksa.restaurantreviews.restauranttype.dtos.RestaurantTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RestaurantTypeMapper {

    RestaurantType toEntity(RestaurantTypeDTO restaurantTypeDTO);

    RestaurantType toEntity(RestaurantTypeCreateDTO restaurantTypeCreateDTO);

    RestaurantTypeDTO toDTO(RestaurantType restaurantType);
}
