package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "documentLengthGroup")
public class DocumentLengthGroup implements Dimension {

    private Integer id;
    private String fineName;
    private Integer fineLowerBound;
    private Integer fineUpperBound;
    private String coarseName;
    private Integer coarseLowerBound;
    private Integer coarseUpperBound;

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
    public Integer getFineLowerBound() {
        return fineLowerBound;
    }

    public void setFineLowerBound(Integer upperBound) {
        this.fineLowerBound = upperBound;
    }

    @Column(name = "fineUpper")
    public Integer getFineUpperBound() {
        return fineUpperBound;
    }

    public void setFineUpperBound(Integer lowerBound) {
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
    public Integer getCoarseLowerBound() {
        return coarseLowerBound;
    }

    public void setCoarseLowerBound(Integer coarseLowerBound) {
        this.coarseLowerBound = coarseLowerBound;
    }

    @Column(name = "coarseUpper")
    public Integer getCoarseUpperBound() {
        return coarseUpperBound;
    }

    public void setCoarseUpperBound(Integer coarseUpperBound) {
        this.coarseUpperBound = coarseUpperBound;
    }

}
