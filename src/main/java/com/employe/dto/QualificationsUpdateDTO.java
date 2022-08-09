package com.employe.dto;

import com.employe.entity.Statut;
import com.employe.entity.Type_Qualification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationsUpdateDTO
{ private String code;
    private String designation;
    private Statut statut;
    private Type_Qualification type_qualification;
}
