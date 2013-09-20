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
    private String monthName;
    private String dayOfMonth;
    private Integer monthOrdinal;
    private Integer dayOrdinal;

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

    @Column(name = "day_of_month")
    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Column(name = "month_ordinal")
    public Integer getMonthOrdinal() {
        return monthOrdinal;
    }

    public void setMonthOrdinal(Integer monthOrdinal) {
        this.monthOrdinal = monthOrdinal;
    }

    @Column(name = "day_ordinal")
    public Integer getDayOrdinal() {
        return dayOrdinal;
    }

    public void setDayOrdinal(Integer dayOrdinal) {
        this.dayOrdinal = dayOrdinal;
    }

    @Transient
    public DateTime getDate() {
        return new DateTime(year, monthOrdinal % 100, dayOrdinal % 100, 0, 0, 0, 0, DateTimeZone.UTC);
    }

    public void setDate(DateTime date) {
        this.year = date.getYear();
        this.monthName = date.toString("MMM yyyy");
        this.dayOfMonth = date.toString("MMM dd, yyyy");
        this.monthOrdinal = (date.getYear() * 100) + date.getMonthOfYear();
        this.monthOrdinal = (date.getYear() * 10000) + (date.getMonthOfYear() * 100) + date.getDayOfMonth();
    }
}
