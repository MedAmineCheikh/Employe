package com.employe.service;

import com.employe.dto.*;
import com.employe.entity.Qualifications;

import java.util.List;

public interface QualificationsService {
    QualificationsResponseDTO save(QualificationsRequestDTO qualificationsRequestDTO);
    QualificationsResponseDTO getQualifications(String id);
    void updateQualifications(QualificationsUpdateDTO dto);
    List<QualificationsResponseDTO> listQualifications();
    public void delete(String id);

    public List<QualificationsResponseDTO> listQualificationsActive();
}
