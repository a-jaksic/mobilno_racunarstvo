package com.jaksa.restaurantreviews.city.mapper;

import com.jaksa.restaurantreviews.city.domain.City;
import com.jaksa.restaurantreviews.city.dtos.CityCreateDTO;
import com.jaksa.restaurantreviews.city.dtos.CityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toEntity(CityDTO cityDTO);

    City toEntity(CityCreateDTO cityCreateDTO);

    CityDTO toDTO(City city);
}