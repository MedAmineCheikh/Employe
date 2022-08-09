package com.employe.mapper;

import com.employe.dto.*;
import com.employe.entity.Employe;
import com.employe.entity.Qualifications;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface QualificationsMapper {
    QualificationsResponseDTO QualificationsTOQualificationsResponseDTO(Qualifications qualifications);
    Qualifications QualificationsRequestDTOQualifications(QualificationsRequestDTO qualificationsRequestDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateQualificationsFromDto(QualificationsUpdateDTO dto, @MappingTarget Qualifications entity);
}
