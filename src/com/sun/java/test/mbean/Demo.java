package com.sun.java.test.mbean;


/**
 * Created by sam on 9/30/15.
 */
public class Demo implements DemoMBean,Runnable {
    private int maxSize;

    @Override public int getValue() {
        return 0;
    }


    @Override
    public int setValue(int val) {
        if(val>=50) {
            throw new RuntimeException("max val exceeded :: " + val);
        }
        return maxSize=val;
    }


    @Override public void run() {

        while(maxSize<50) {
            System.out.println("maxSize="+maxSize);
            maxSize=++maxSize;
            try {
                Thread.sleep(2345);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
