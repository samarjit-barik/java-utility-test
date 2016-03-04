package com.sun.java.test;


/**
 * Created by sam on 4/15/15.
 */
public class ThreadTypeA implements Runnable {
    @Override public void run() {
        System.out.println("ThreadTypeA");
    }
}
