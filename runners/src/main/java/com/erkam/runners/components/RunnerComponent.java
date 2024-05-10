package com.erkam.runners.components;

import com.erkam.runners.model.Runner;
import com.erkam.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerComponent {

    @Autowired
    private RunnerRepository runnerRepository;
    public List<Runner> allRunner(){
        return runnerRepository.findAll();
    }
    public Runner createRunner(String nev,String neme, Integer kor){

        Runner runner = new Runner();
        runner.setNev(nev);
        runner.setNeme(neme);
        runner.setKor(kor);

        return runnerRepository.save(runner);
    }
}
