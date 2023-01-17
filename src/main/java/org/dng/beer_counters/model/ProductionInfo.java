package org.dng.beer_counters.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ProductionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column
    private LocalDate date;

    @Basic
    @Column
    private LocalTime time;

    @Basic
    @Column
    private WorkMode mode;

    @Basic
    @Column
    private long nomenclatureId;

    @Basic
    @Column
    private int counterBegin;

    @Basic
    @Column
    private int counterEnd;

    @Basic
    @Column
    private int valueProductionPassed2Store;

    @Basic
    @Column
    private int valueProductionReturned2Manufacturing;

    @Basic
    @Column
    private int valueLoss;

    @Basic
    @Column
    private String comment;

    @Basic
    @Column
    private String guilty;



}
