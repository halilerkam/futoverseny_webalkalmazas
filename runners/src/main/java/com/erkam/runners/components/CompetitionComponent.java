package com.erkam.runners.components;

import com.erkam.runners.model.Competition;
import com.erkam.runners.repository.CompRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
@Service
public class CompetitionComponent {
    @Autowired
    private CompRepository compRepository;
    public ModelAndView allComp() {
        ModelAndView mav= new ModelAndView("compAll");
        List<Competition> comps= compRepository.findAll();
        mav.addObject("competition",comps);
        return mav;
    }
    public Optional<Competition> getupdateComp(Integer id, String compName, Integer distance) {
        Optional<Competition> optionalComp = compRepository.findById(id);
        if (optionalComp.isPresent()) {
            Competition comp = optionalComp.get();
            comp.setCompName(compName);
            comp.setDist(distance);
            return Optional.of(compRepository.save(comp));
        } else {
            return Optional.empty();
        }
    }
}