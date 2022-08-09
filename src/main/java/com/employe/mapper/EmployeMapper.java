package com.employe.mapper;

import com.employe.dto.EmployeRequestDTO;
import com.employe.dto.EmployeResponseDTO;
import com.employe.dto.EmployeUpdateDTO;
import com.employe.entity.Employe;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeResponseDTO EmployeTOEmployeResponseDTO(Employe employe);
    Employe EmployeRequestDTOEmploye(EmployeRequestDTO employeRequestDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeFromDto(EmployeUpdateDTO dto, @MappingTarget Employe entity);
}
