package com.employe.repository;

import com.employe.entity.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite,String> {

 @Query("select a from  Activite a where a.statut=com.employe.entity.Statut.Activer")
    List<Activite> findByActive();
}
