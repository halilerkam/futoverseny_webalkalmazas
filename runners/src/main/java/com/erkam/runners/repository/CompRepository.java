package com.erkam.runners.repository;
import com.erkam.runners.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompRepository extends JpaRepository<Competition, Integer> {
    Optional<Competition> findById(Integer id);
    Competition findRaceByCompName(String compName);


}