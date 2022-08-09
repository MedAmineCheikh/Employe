package com.employe.mapper;

import com.employe.dto.*;
import com.employe.entity.Activite;
import com.employe.entity.Qualifications;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ActiviteMapper {
    ActiviteResponseDTO ActiviteTOActiviteResponseDTO(Activite activite);
    Activite ActiviteRequestDTOActivite(ActiviteRequestDTO activiteRequestDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateActiviteFromDto(ActiviteUpdateDTO dto, @MappingTarget Activite entity);
}
