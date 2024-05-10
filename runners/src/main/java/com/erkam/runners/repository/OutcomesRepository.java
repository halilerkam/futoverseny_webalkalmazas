package com.erkam.runners.repository;
import com.erkam.runners.model.Outcomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OutcomesRepository extends JpaRepository<Outcomes,Integer> {
    @Query("SELECT r.runner.nev, r.time FROM Outcomes r WHERE r.comp.id = :compId ORDER BY r.time ASC")
    List<Object[]> findOutcomesCompId(@Param("compId") int compId);
    @Query("SELECT AVG(r.time) AS average_time FROM Outcomes r WHERE r.comp.id = :compId")
    Optional<Double> findAverageTimeByCompId(@Param("compId") int compId);


    //Outcomes addOutcome(String runnerName, String compName, Integer time);
}


