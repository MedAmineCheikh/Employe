package com.employe.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualifications implements Serializable {
    @Id
    private String code;
    @NotNull
    private String designation;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Statut statut;
        @NotNull
    @Enumerated(EnumType.STRING)
    private Type_Qualification type_qualification;
}
