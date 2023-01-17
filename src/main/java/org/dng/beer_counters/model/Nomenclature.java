package org.dng.beer_counters.model;

import jakarta.persistence.*;

@Entity
public class Nomenclature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name="name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

}
