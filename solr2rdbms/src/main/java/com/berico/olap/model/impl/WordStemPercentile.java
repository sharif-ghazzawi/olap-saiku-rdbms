package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "wordStemPercentile")
public class WordStemPercentile implements Dimension {

    private Integer id;
    private int upperBound;
    private int lowerBound;
    private Integer coarseId;
    private int coarseUpperBound;
    private int coarseLowerBound;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "upper")
    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Column(name = "lower")
    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Column(name = "coarseId")
    public Integer getCoarseId() {
        return coarseId;
    }

    public void setCoarseId(Integer coarseId) {
        this.coarseId = coarseId;
    }

    @Column(name = "coarseUpper")
    public int getCoarseUpperBound() {
        return coarseUpperBound;
    }

    public void setCoarseUpperBound(int coarseUpperBound) {
        this.coarseUpperBound = coarseUpperBound;
    }

    @Column(name = "coarseLower")
    public int getCoarseLowerBound() {
        return coarseLowerBound;
    }

    public void setCoarseLowerBound(int coarseLowerBound) {
        this.coarseLowerBound = coarseLowerBound;
    }
}
