package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;

import javax.persistence.*;

@Entity
@Table(name = "collectionDate")
public class CollectionDate implements Dimension {

    private Integer id;
    private Integer year;
    private Short month;
    private String monthName;
    private Short dayOfMonth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "monthName")
    public String getMonthName() {
        return monthName;
    }

    private void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Column(name = "month")
    public Short getMonth() {
        return month;
    }

    public void setMonth(Short month) {
        this.month = month;
    }

    @Column(name = "dayOfMonth")
    public Short getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Short dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
