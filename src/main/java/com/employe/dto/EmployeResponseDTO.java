package com.employe.dto;

import com.employe.entity.Activite;
import com.employe.entity.Statut;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
public class EmployeResponseDTO {
    private String matricule;
    private String prenom_Nom;
    private Boolean chef_Projet;
    private Date charge_Salariale;
    private String n_Permis;
    private String n_Cin;
    private Statut statut;
    private List<Activite> qualifications;
}
