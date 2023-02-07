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
    @Enumerated(EnumType.STRING)
    private WorkMode mode;

    @ManyToOne()
    @JoinColumn(name = "nomenclature_id", referencedColumnName = "id", nullable = true)
    private Nomenclature nomenclature;

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
    private String guilty; //виноватый ))


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public WorkMode getMode() {
        return mode;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public int getCounterBegin() {
        return counterBegin;
    }

    public int getCounterEnd() {
        return counterEnd;
    }

    public int getValueProductionPassed2Store() {
        return valueProductionPassed2Store;
    }

    public int getValueProductionReturned2Manufacturing() {
        return valueProductionReturned2Manufacturing;
    }

    public int getValueLoss() {
        return valueLoss;
    }

    public String getComment() {
        return comment;
    }

    public String getGuilty() {
        return guilty;
    }

    //**** Setters ****
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMode(WorkMode mode) {
        this.mode = mode;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setCounterBegin(int counterBegin) {
        this.counterBegin = counterBegin;
    }

    public void setCounterEnd(int counterEnd) {
        this.counterEnd = counterEnd;
    }

    public void setValueProductionPassed2Store(int valueProductionPassed2Store) {
        this.valueProductionPassed2Store = valueProductionPassed2Store;
    }

    public void setValueProductionReturned2Manufacturing(int valueProductionReturned2Manufacturing) {
        this.valueProductionReturned2Manufacturing = valueProductionReturned2Manufacturing;
    }

    public void setValueLoss(int valueLoss) {
        this.valueLoss = valueLoss;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGuilty(String guilty) {
        this.guilty = guilty;
    }
}
