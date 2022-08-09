package com.employe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe implements Serializable {
    @Id
    private String matricule;
    private String prenom_Nom;
    private Boolean chef_Projet;
    @Temporal(TemporalType.DATE)
    private Date charge_Salariale;
    private String n_Permis;
    private String n_Cin;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @JsonIgnore
    @ManyToMany(cascade={PERSIST, DETACH})
    private List<Activite> qualifications;
}
