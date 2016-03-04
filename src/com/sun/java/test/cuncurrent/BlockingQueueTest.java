package com.sun.java.test.cuncurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by sam on 2/17/16.
 */
public class BlockingQueueTest {

    public static void main (String args[]) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(5, true);
        //LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();


        for(int i=0; i<=9; i++) {
            System.out.println("put : " + i);

            if(arrayBlockingQueue.remainingCapacity() > 0) {
                arrayBlockingQueue.put(i);
            } else {

            }
        }

        System.out.println("Element : " + arrayBlockingQueue.take());
        System.out.println("Element : " + arrayBlockingQueue.take());
        System.out.println("Remaining Capacity : " + arrayBlockingQueue.remainingCapacity());
    }
}
