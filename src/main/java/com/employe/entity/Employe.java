package com.employe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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
    @NotNull
    private String prenom_Nom;
    @NotNull
    private Boolean chef_Projet;
    @Temporal(TemporalType.DATE)
    private Date charge_Salariale;
    @NotNull
    private String n_Permis;
    @Column(unique = true)
    @NotNull
    private String n_Cin;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Statut statut;
    @JsonIgnore
    @ManyToMany(cascade={PERSIST, DETACH},fetch = FetchType.EAGER)
    private List<Activite> qualifications;
}
