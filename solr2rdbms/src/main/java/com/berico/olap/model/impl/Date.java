package com.berico.olap.model.impl;

import com.berico.olap.model.Dimension;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;

@Entity
@Table(name = "full_date")
public class Date implements Dimension {

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

    @Column(name = "month_name")
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

    @Column(name = "day_of_month")
    public Short getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Short dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Transient
    public DateTime getDate() {
        return new DateTime(year, month, dayOfMonth, 0, 0, 0, 0, DateTimeZone.UTC);
    }

    public void setDate(DateTime date) {
        this.year = date.getYear();
        this.month = (short) date.getMonthOfYear();
        this.dayOfMonth = (short) date.getDayOfMonth();
        this.monthName = date.toString("MMM");
    }
}
