package com.sun.java.test.excecutor;


/**
 * Created by sam on 9/24/15.
 */
public class Coordinator implements Runnable {

    public Coordinator() {
        this.init();
    }

    public void init() {
        DBManager dbManager = new DBManager(this);
        ExecutorServiceProvider.getExecutorService().submit(dbManager);

        DBDownloader dbDownloader = new DBDownloader(dbManager);
        ExecutorServiceProvider.getExecutorService().submit(dbDownloader);


        RecordPusher pusher = new RecordPusher(dbDownloader);
        ExecutorServiceProvider.getExecutorService().submit(pusher);
    }

    @Override
    public void run() {

    }
}
