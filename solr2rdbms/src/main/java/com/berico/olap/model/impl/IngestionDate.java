package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "ingest_date")
public class IngestionDate implements Dimension<String> {
    private String id;
    private int ingDateMonth;
    private int ingDateYear;

    @Column(name = "ingDateMonth")
    public int getIngDateMonth() {
        return ingDateMonth;
    }

    public void setIngDateMonth(int ingDateMonth) {
        this.ingDateMonth = ingDateMonth;
    }

    @Column(name = "ingDateMonth")
    public int getIngDateYear() {
        return ingDateYear;
    }

    public void setIngDateYear(int ingDateYear) {
        this.ingDateYear = ingDateYear;
    }

    @Id
    @Column(name = "ingDateId")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
