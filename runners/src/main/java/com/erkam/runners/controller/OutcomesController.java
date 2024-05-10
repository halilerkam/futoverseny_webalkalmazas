package com.erkam.runners.controller;

import com.erkam.runners.components.OutcomesComponent;
import com.erkam.runners.model.Competition;
import com.erkam.runners.model.Outcomes;
import com.erkam.runners.model.Runner;
import com.erkam.runners.repository.OutcomesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/outcomes")
public class OutcomesController {

    @Autowired
    private OutcomesComponent outcomesComponent;

    @GetMapping("/getOutcome")
    public ResponseEntity<List<Outcomes>> getAllOutcomes(){
        return new ResponseEntity<List<Outcomes>>(outcomesComponent.allResult(), HttpStatus.OK);
    }

    @PostMapping("/addOutcome")
    public ResponseEntity<Outcomes> addOutcome(@RequestBody Map<String, Object> payload) {
        String runnerName = (String) payload.get("runnerName");
        String compName = (String) payload.get("compName");
        Integer time = (Integer) payload.get("time");

        Outcomes outcome = outcomesComponent.addOutcome(runnerName, compName, time);
        return ResponseEntity.ok(outcome);
    }

    @GetMapping("/getAverageTime/{raceId}")
    public ResponseEntity<Optional<Double>>getAverageTime(@PathVariable Integer compId){
        return new ResponseEntity<Optional<Double>>(outcomesComponent.averageTime(compId),HttpStatus.OK);
    }
}