package com.sun.java.test.excecutor;


import java.sql.Timestamp;


/**
 * Created by sam on 9/24/15.
 */
public class DateRange {
    private Timestamp fromDate;
    private Timestamp toDate;
    private int count;


    public Timestamp getToDate() {
        return toDate;
    }


    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }


    public Timestamp getFromDate() {
        return fromDate;
    }


    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }
}
