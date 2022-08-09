package com.employe.service;

import com.employe.dto.ActiviteRequestDTO;
import com.employe.dto.ActiviteResponseDTO;
import com.employe.dto.ActiviteUpdateDTO;
import com.employe.entity.Activite;

import java.util.List;

public interface ActiviteService {
    ActiviteResponseDTO save(ActiviteRequestDTO activiteRequestDTO);
    ActiviteResponseDTO getActivite(String id);

    List<ActiviteResponseDTO> listActivites();
    void updateActivite(ActiviteUpdateDTO dto);
    void delete(String id);
    public List<ActiviteResponseDTO> listActivitesActive();
}
