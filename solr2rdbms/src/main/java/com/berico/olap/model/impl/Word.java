package com.berico.olap.model.impl;

import com.berico.olap.model.*;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word implements Dimension {

    private Integer id;
    private String word;
    private String stem;
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

    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String name) {
        this.word = name;
    }

    @Column(name = "stem")
    public String getStem() {
        return stem;
    }

    public void setStem(String concept) {
        this.stem = concept;
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