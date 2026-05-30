package com.jaksa.restaurantreviews.user.mapper;

import com.jaksa.restaurantreviews.user.domain.User;
import com.jaksa.restaurantreviews.security.dtos.UserLoginDTO;
import com.jaksa.restaurantreviews.user.dtos.UserRegisterDTO;
import com.jaksa.restaurantreviews.user.dtos.UserResponseDTO;
import com.jaksa.restaurantreviews.user.dtos.UserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(UserRegisterDTO userRegisterDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(UserLoginDTO userLoginDTO);


    UserResponseDTO toResponseDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateEntityFromUpdateDto(UserUpdateDTO userUpdateDTO, @MappingTarget User user);

}
