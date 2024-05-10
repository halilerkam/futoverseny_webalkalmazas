package com.erkam.runners.repository;
import com.erkam.runners.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface RunnerRepository extends JpaRepository<Runner, Integer> {
    Runner findByNev(String nev);
}
