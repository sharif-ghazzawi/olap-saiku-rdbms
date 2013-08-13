package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "collection_date")
public class CollectionDate implements Dimension<String> {
    private String id;
    private int colDateMonth;
    private int colDateYear;

    @Id
    @Column(name = "colDateId")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "colDateMonth")
    public int getColDateMonth() {
        return colDateMonth;
    }

    public void setColDateMonth(int colDateMonth) {
        this.colDateMonth = colDateMonth;
    }

    @Column(name = "colDateYear")
    public int getColDateYear() {
        return colDateYear;
    }

    public void setColDateYear(int colDateYear) {
        this.colDateYear = colDateYear;
    }


}
