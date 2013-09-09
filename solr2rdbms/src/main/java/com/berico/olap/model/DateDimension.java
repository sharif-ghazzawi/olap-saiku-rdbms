package com.berico.olap.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.Transient;

public abstract class DateDimension implements Dimension {

    protected Integer year;
    protected Short month;
    protected String monthName;
    protected Short dayOfMonth;

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
