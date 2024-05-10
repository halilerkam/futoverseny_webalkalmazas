package com.erkam.runners;

import com.erkam.runners.model.Competition;
import com.erkam.runners.model.Outcomes;
import com.erkam.runners.model.Runner;
import com.erkam.runners.repository.CompRepository;
import com.erkam.runners.repository.OutcomesRepository;
import com.erkam.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@Component
public class RunnersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	@Autowired
	private RunnerRepository runnerRepository;
	@Autowired
	private CompRepository compRepository;
	@Autowired
	private OutcomesRepository outcomesRepository;

	@Override
	public void run(String... args) throws Exception {
		Runner runner1 = new Runner("John Doe", "male", 30);
		Runner runner2 = new Runner("Jane Smith", "female", 25);
		Runner runner3 = new Runner("Peter Smith", "male", 18);
		Runner runner4 = new Runner("Jazmin Kovacs", "male", 36);
		Runner runner5 = new Runner("Simeon Szabó", "male", 19);
		Runner runner6 = new Runner("Thomas Kroos", "male", 20);
		Runner runner7 = new Runner("Kristof Nagy", "male", 25);
		Runner runner8 = new Runner("Lili Szegedi", "female", 16);

		runnerRepository.saveAll(Arrays.asList(runner1, runner2,runner3, runner4,runner5,runner6,runner7,runner8));

		Competition comp1= new Competition("BalatonGo",10);
		Competition comp2= new Competition("VelenceGo",5);
		Competition comp3= new Competition("GyörGo",15);
		Competition comp4= new Competition("BudapestGo",20);
		Competition comp5= new Competition("DebrecenGo",17);

		compRepository.saveAll(Arrays.asList(comp1,comp2,comp3,comp4,comp5));

		Outcomes outcome1 = new Outcomes(runner1,comp2,50);
		Outcomes outcome2 = new Outcomes(runner2,comp5,31);
		Outcomes outcome3 = new Outcomes(runner4,comp4,36);
		Outcomes outcome4 = new Outcomes(runner5,comp1,86);
		Outcomes outcome5 = new Outcomes(runner8,comp2,122);
		Outcomes outcome6 = new Outcomes(runner3,comp2,54);
		Outcomes outcome7 = new Outcomes(runner7,comp2,91);
		Outcomes outcome8 = new Outcomes(runner6,comp5,32);

		outcomesRepository.saveAll(Arrays.asList(outcome1,outcome2,outcome3,outcome4,outcome5,outcome6,outcome7,outcome8));
	}
}
