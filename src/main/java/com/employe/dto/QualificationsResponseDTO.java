package com.employe.dto;

import com.employe.entity.Statut;
import com.employe.entity.Type_Qualification;
import lombok.Data;

@Data
public class QualificationsResponseDTO {
    private String code;
    private String designation;
    private Statut statut;
    private Type_Qualification type_qualification;
}
