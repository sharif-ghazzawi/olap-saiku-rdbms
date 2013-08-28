package com.berico.olap.model.impl;

import com.berico.olap.model.*;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word implements Dimension {

    private Integer id;
    private String name;
    private String concept;
    private int fineId;
    private String fineName;
    private int mediumId;
    private String mediumName;
    private int coarseId;
    private String coarseName;
    private float evImportance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "concept")
    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    @Column(name = "fineId")
    public int getFineId() {
        return fineId;
    }

    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    @Column(name = "fineName")
    public String getFineName() {
        return fineName;
    }

    public void setFineName(String fineName) {
        this.fineName = fineName;
    }

    @Column(name = "mediumId")
    public int getMediumId() {
        return mediumId;
    }

    public void setMediumId(int mediumId) {
        this.mediumId = mediumId;
    }

    @Column(name = "mediumName")
    public String getMediumName() {
        return mediumName;
    }

    public void setMediumName(String mediumName) {
        this.mediumName = mediumName;
    }

    @Column(name = "coarseId")
    public int getCoarseId() {
        return coarseId;
    }

    public void setCoarseId(int coarseId) {
        this.coarseId = coarseId;
    }

    @Column(name = "coarseName")
    public String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(String coarseName) {
        this.coarseName = coarseName;
    }

    @Column(name = "evImportance")
    public float getEvImportance() {
        return evImportance;
    }

    public void setEvImportance(float evImportance) {
        this.evImportance = evImportance;
    }
}