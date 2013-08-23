package com.berico.olap.model.impl;

import com.berico.olap.model.*;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word implements Dimension {

    private Integer id;
    private String word;
    private String stem;
    private String fine;
    private String medium;
    private String coarse;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "word")
    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Column(name = "stem")
    public String getStem() {
        return this.stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    @Column(name = "fine")
    public String getFine() {
        return this.fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Column(name = "medium")
    public String getMedium() {
        return this.medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Column(name = "coarse")
    public String getCoarse() {
        return this.coarse;
    }

    public void setCoarse(String coarse) {
        this.coarse = coarse;
    }

}