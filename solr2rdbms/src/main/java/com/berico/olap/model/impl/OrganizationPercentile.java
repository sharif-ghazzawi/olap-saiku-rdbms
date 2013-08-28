package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "organizationPercentile")
public class OrganizationPercentile implements Dimension {

    private Integer id;
    private short percentile;
    private String coarseName;
    private int coarseUpperBound;
    private int coarseLowerBound;

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
    public short getPercentile() {
        return percentile;
    }

    public void setPercentile(short percentile) {
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
