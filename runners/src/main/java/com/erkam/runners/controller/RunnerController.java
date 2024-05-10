package com.erkam.runners.controller;

import com.erkam.runners.model.Runner;
import com.erkam.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/runner")
public class RunnerController {
    @Autowired
    private RunnerRepository runnerRepository;

    @GetMapping("/getRunner")
    public ResponseEntity<List<Runner>> getAllRunner(){
        return new ResponseEntity<List<Runner>>(runnerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addRunner")
    public ResponseEntity<Runner> addRunner(@RequestBody Map<String, Object> payload) {
        String nev = (String) payload.get("nev");
        String neme = (String) payload.get("neme");
        Integer kor = (Integer) payload.get("kor");


        Runner runner = new Runner(nev, neme, kor);
        return new ResponseEntity<>(runner, HttpStatus.OK);
    }
}
