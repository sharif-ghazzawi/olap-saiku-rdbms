package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization implements Dimension {

    private Integer id;
    private String name;
    private String fine;
    private String medium;
    private String coarse;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "fine")
    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Column(name = "medium")
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Column(name = "coarse")
    public String getCoarse() {
        return coarse;
    }

    public void setCoarse(String coarse) {
        this.coarse = coarse;
    }

}
