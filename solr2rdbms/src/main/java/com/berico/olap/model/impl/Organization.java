package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization implements Dimension {

    private Integer id;
    private String name;
    private String concept;
    private Integer fineId;
    private String fineName;
    private Integer mediumId;
    private String mediumName;
    private Integer coarseId;
    private String coarseName;
    private Float evImportance;

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
    public Integer getFineId() {
        return fineId;
    }

    public void setFineId(Integer fineId) {
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
    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
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
    public Integer getCoarseId() {
        return coarseId;
    }

    public void setCoarseId(Integer coarseId) {
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
    public Float getEvImportance() {
        return evImportance;
    }

    public void setEvImportance(Float evImportance) {
        this.evImportance = evImportance;
    }
}
