package com.employe.dto;

import com.employe.entity.Type_Activite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteRequestDTO extends QualificationsRequestDTO{
    private Type_Activite type_activite;
}
