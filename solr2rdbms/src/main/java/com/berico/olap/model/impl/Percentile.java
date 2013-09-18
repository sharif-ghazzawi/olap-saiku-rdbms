package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "percentile")
public class Percentile implements Dimension {

    private Integer id;
    private short percentile;
    private String coarseNameLength;
    private String coarseNamePosition;
    private String coarseNameCommonness;
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

    @Column(name = "coarse_name_length")
    public String getCoarseNameLength() {
        return coarseNameLength;
    }

    public void setCoarseNameLength(String coarseNameLength) {
        this.coarseNameLength = coarseNameLength;
    }

    @Column(name = "coarse_name_position")
    public String getCoarseNamePosition() {
        return coarseNamePosition;
    }

    public void setCoarseNamePosition(String coarseNamePosition) {
        this.coarseNamePosition = coarseNamePosition;
    }

    @Column(name = "coarse_name_commonness")
    public String getCoarseNameCommonness() {
        return coarseNameCommonness;
    }

    public void setCoarseNameCommonness(String coarseNameCommonness) {
        this.coarseNameCommonness = coarseNameCommonness;
    }

    @Column(name = "coarse_upper")
    public int getCoarseUpperBound() {
        return coarseUpperBound;
    }

    public void setCoarseUpperBound(int coarseUpperBound) {
        this.coarseUpperBound = coarseUpperBound;
    }

    @Column(name = "coarse_lower")
    public int getCoarseLowerBound() {
        return coarseLowerBound;
    }

    public void setCoarseLowerBound(int coarseLowerBound) {
        this.coarseLowerBound = coarseLowerBound;
    }
}
