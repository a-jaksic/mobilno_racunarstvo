package com.jaksa.restaurantreviews.workday.mapper;

import com.jaksa.restaurantreviews.workday.domain.WorkDay;
import com.jaksa.restaurantreviews.workday.dtos.WorkDayCreateUpdateDTO;
import com.jaksa.restaurantreviews.workday.dtos.WorkDayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface WorkDayMapper {

    WorkDay toEntity(WorkDayDTO workDayDTO);

    WorkDay toEntity(WorkDayCreateUpdateDTO workDayCreateUpdateDTO);

    WorkDayDTO toDTO(WorkDay workDay);

    void updateEntityFromUpdateDto(WorkDayCreateUpdateDTO workDayCreateUpdateDTO, @MappingTarget WorkDay workDay);
}
