package com.sun.java.test.excecutor;


import java.util.concurrent.SynchronousQueue;


/**
 * Created by sam on 9/24/15.
 */
public class RecordPusher implements Runnable {
    private DBDownloader downloader = null;

    public RecordPusher(DBDownloader downloader) {
        this.downloader = downloader;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
                SynchronousQueue<StringBuffer> recordPusher = this.downloader.getRecordPusherSynchronousQueue();
                StringBuffer sb = recordPusher.take();

                System.out.println("Record retrieve in pusher :: " + sb.toString());
                // Push Record To Index Quese
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
