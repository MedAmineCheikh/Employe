package com.employe.repository;

import com.employe.entity.Qualifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationsRepository extends JpaRepository<Qualifications,String> {
    @Query("select q from Qualifications q where q.statut=com.employe.entity.Statut.Activer")
    List<Qualifications> findByActiveQualifications();
}
