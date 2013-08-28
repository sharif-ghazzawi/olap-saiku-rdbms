package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "documentLengthGroup")
public class DocumentLengthGroup implements Dimension {

    private Integer id;
    private String fineName;
    private int fineLowerBound;
    private int fineUpperBound;
    private String coarseName;
    private int coarseLowerBound;
    private int coarseUpperBound;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "fineName")
    public String getFineName() {
        return fineName;
    }

    public void setFineName(String fineName) {
        this.fineName = fineName;
    }

    @Column(name = "fineLower")
    public int getFineLowerBound() {
        return fineLowerBound;
    }

    public void setFineLowerBound(int upperBound) {
        this.fineLowerBound = upperBound;
    }

    @Column(name = "fineUpper")
    public int getFineUpperBound() {
        return fineUpperBound;
    }

    public void setFineUpperBound(int lowerBound) {
        this.fineUpperBound = lowerBound;
    }

    @Column(name = "coarseName")
    public String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(String coarseName) {
        this.coarseName = coarseName;
    }

    @Column(name = "coarseLower")
    public int getCoarseLowerBound() {
        return coarseLowerBound;
    }

    public void setCoarseLowerBound(int coarseLowerBound) {
        this.coarseLowerBound = coarseLowerBound;
    }

    @Column(name = "coarseUpper")
    public int getCoarseUpperBound() {
        return coarseUpperBound;
    }

    public void setCoarseUpperBound(int coarseUpperBound) {
        this.coarseUpperBound = coarseUpperBound;
    }

}
