package com.erkam.runners.controller;

import com.erkam.runners.model.Competition;
import com.erkam.runners.repository.CompRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/comp")
public class CompetitionController {
    @Autowired
    private CompRepository compRepository;


    @GetMapping("/getComp")
    public ModelAndView getAllComp(){
        return (ModelAndView) compRepository.findAll();
    }

    @PostMapping("/updateComp")
    public ResponseEntity<String> updateComp(@RequestBody Map<String, Object> payload) {
        if (!payload.containsKey("id") || !payload.containsKey("compName") || !payload.containsKey("distance")) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        Integer id = (Integer) payload.get("id");
        String compName = (String) payload.get("compName");
        Integer distance = (Integer) payload.get("distance");

        Optional<Competition> updatedComp = Optional.ofNullable(compRepository.findRaceByCompName(compName));
        if (updatedComp.isPresent()) {
            return ResponseEntity.ok("Competition updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
