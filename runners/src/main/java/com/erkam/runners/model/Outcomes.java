package com.erkam.runners.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outcomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "runnerId", referencedColumnName = "id")
    private Runner runner;

    @ManyToOne
    @JoinColumn(name = "raceId", referencedColumnName = "id")
    private Competition comp;

    private int time;
    public Outcomes(Runner runner, Competition comp, int time) {
        this.runner = runner;
        this.comp = comp;
        this.time = time;
    }
}
