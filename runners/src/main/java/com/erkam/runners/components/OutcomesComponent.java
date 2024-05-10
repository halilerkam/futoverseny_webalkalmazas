package com.erkam.runners.components;

import com.erkam.runners.model.Competition;
import com.erkam.runners.model.Outcomes;
import com.erkam.runners.model.Runner;
import com.erkam.runners.repository.CompRepository;
import com.erkam.runners.repository.OutcomesRepository;
import com.erkam.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OutcomesComponent {
    @Autowired
    private OutcomesRepository outcomesRepository;
    @Autowired
    private CompRepository compRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    public List<Outcomes> allResult()
    {

        return outcomesRepository.findAll();
    }
    public List<Object[]>compRunner(Integer compId){
        return outcomesRepository.findOutcomesCompId(compId);
    }
    public Outcomes addOutcome(String runnerNev,String compName,Integer time){
        Runner runner= runnerRepository.findByNev(runnerNev);
        Competition comp= compRepository.findRaceByCompName(compName);
        if (comp!= null && runner!= null){
            Outcomes outcome= new Outcomes(runner,comp,time);
            return outcomesRepository.save(outcome);
        }
        else {
            throw new RuntimeException("Runner hiba.");
        }
    }
    public Optional<Double> averageTime(Integer compId){
        return outcomesRepository.findAverageTimeByCompId(compId);
    }
}