package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "wordStemPercentile")
public class WordStemPercentile implements Dimension {

    private Integer id;
    private Short percentile;
    private String coarseName;
    private Integer coarseUpperBound;
    private Integer coarseLowerBound;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "percentile")
    public Short getPercentile() {
        return percentile;
    }

    public void setPercentile(Short percentile) {
        this.percentile = percentile;
    }

    @Column(name = "coarseName")
    public String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(String coarseName) {
        this.coarseName = coarseName;
    }

    @Column(name = "coarseUpper")
    public Integer getCoarseUpperBound() {
        return coarseUpperBound;
    }

    public void setCoarseUpperBound(Integer coarseUpperBound) {
        this.coarseUpperBound = coarseUpperBound;
    }

    @Column(name = "coarseLower")
    public Integer getCoarseLowerBound() {
        return coarseLowerBound;
    }

    public void setCoarseLowerBound(Integer coarseLowerBound) {
        this.coarseLowerBound = coarseLowerBound;
    }
}
