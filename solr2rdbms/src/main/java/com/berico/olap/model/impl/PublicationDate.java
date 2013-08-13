package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "publication_date")
public class PublicationDate implements Dimension<String> {
    private String id;
    private int pubDateMonth;
    private int pubDateYear;

    @Id
    @Column(name = "pubDateId")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;

    }

    @Column(name = "pubDateMonth")
    public int getPubDateMonth() {
        return pubDateMonth;
    }

    public void setPubDateMonth(int pubDateMonth) {
        this.pubDateMonth = pubDateMonth;
    }

    @Column(name = "pubDateYear")
    public int getPubDateYear() {
        return pubDateYear;
    }

    public void setPubDateYear(int pubDateYear) {
        this.pubDateYear = pubDateYear;
    }


}
