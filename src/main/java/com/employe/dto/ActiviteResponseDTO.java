package com.employe.dto;

import com.employe.entity.Type_Activite;
import lombok.Data;

@Data
public class ActiviteResponseDTO extends QualificationsResponseDTO{
    private Type_Activite type_activite;
}
