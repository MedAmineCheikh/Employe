package com.employe.service;

import com.employe.dto.EmployeRequestDTO;
import com.employe.dto.EmployeResponseDTO;
import com.employe.dto.EmployeUpdateDTO;
import com.employe.entity.Employe;

import java.util.List;

public interface EmployeService {
    EmployeResponseDTO save(EmployeRequestDTO employeRequestDTO);

    EmployeResponseDTO getEmploye(String id);

    List<EmployeResponseDTO> listEmployes();
    void delete(String id);
    void affecterActiviteToEmploye(String code, String matricule);
  /*  void desaffecterEmployeDuActivite(String employeId, String depId);*/
  void updateEmployeDTO(EmployeUpdateDTO dto);

    List<EmployeResponseDTO> listActiveEmployes();
}
