package com.employe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activite extends Qualifications{
    @Enumerated(EnumType.STRING)
    private Type_Activite type_activite;
    @ManyToMany(mappedBy = "qualifications",cascade={PERSIST, DETACH})
    @JsonIgnore
    private List<Employe>employes ;
}
