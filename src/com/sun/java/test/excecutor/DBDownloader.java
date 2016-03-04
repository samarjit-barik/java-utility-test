package com.sun.java.test.excecutor;


import java.util.concurrent.SynchronousQueue;


/**
 * Created by sam on 9/24/15.
 */
public class DBDownloader implements Runnable {

    private DBManager dbManager = null;
    private SynchronousQueue<StringBuffer> recordPusherSynchronousQueue =
            new SynchronousQueue<StringBuffer>(true);


    public DBDownloader(DBManager dbManager) {
        this.dbManager = dbManager;
    }


    public SynchronousQueue<StringBuffer> getRecordPusherSynchronousQueue() {
        return recordPusherSynchronousQueue;
    }


    @Override
    public void run() {

        while (true) {
            SynchronousQueue<DateRange> dateRangeSynchronousQueue =
                    dbManager.getDateRangeSynchronousQueue();

            try {
                DateRange dateRange = dateRangeSynchronousQueue.take();
                StringBuffer sb = new StringBuffer("RECORD");

                //TODO :: Code to fetch txn data for the date range provided
                // Code here

                // submitting to push queue
                recordPusherSynchronousQueue.put(sb);
                System.out.println(
                        "Successfully pushed records : FROM :: " + dateRange.getFromDate() +
                                " :: To :: " + dateRange.getToDate() + " :: COUNT : " + dateRange.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
