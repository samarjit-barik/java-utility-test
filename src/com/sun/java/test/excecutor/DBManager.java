package com.sun.java.test.excecutor;


import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;


/**
 * Created by sam on 9/24/15.
 */
public class DBManager implements Runnable {

    public Coordinator coordinator = null;
    private SynchronousQueue<DateRange> dateRangeSynchronousQueue =
            new SynchronousQueue<DateRange>(true);

    public String fromDate = null;
    public String toDate = null;
    private int count;


    public DBManager(Coordinator coordinator) {
        this.coordinator = coordinator;
    }


    public SynchronousQueue<DateRange> getDateRangeSynchronousQueue() {
        return dateRangeSynchronousQueue;
    }


    public void setDateRangeSynchronousQueue(
            SynchronousQueue<DateRange> dateRangeSynchronousQueue) {
        this.dateRangeSynchronousQueue = dateRangeSynchronousQueue;
    }


    @Override
    public void run() {
        System.out.println("Starting...DBManager...");
        while(true) {
            this.count ++;
            Timestamp fromDate = new Timestamp(new Date().getTime());
            Timestamp toDate = new Timestamp(new Date().getTime());

            DateRange dateRange = new DateRange();
            dateRange.setFromDate(fromDate);
            dateRange.setToDate(toDate);
            dateRange.setCount(this.count);

            try {
                dateRangeSynchronousQueue.put(dateRange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
