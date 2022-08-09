package com.employe.repository;

import com.employe.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,String> {

    @Query("SELECT e FROM Employe e WHERE e.statut = com.employe.entity.Statut.Activer")
    List<Employe> findEmployesByStatutActiver();
}
