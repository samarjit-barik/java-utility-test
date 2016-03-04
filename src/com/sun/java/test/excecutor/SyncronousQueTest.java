package com.sun.java.test.excecutor;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;


/**
 * Created by sam on 9/23/15.
 */
public class SyncronousQueTest {

    public static void main(String args[]) {
        SynchronousQueue<String> queue = new SynchronousQueue<String>(true);

//        try {
//            queue.put("INITIAL VALE");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ExecutorService service = Executors.newCachedThreadPool();
        Push push = new Push(queue);
        Runnable pull = new Pull(push.getQueue());

        Runnable demo = new Demo();

        service.submit(pull);
        service.submit(push);

        //service.submit(demo);

    }
}


class Push implements Runnable {
    public SynchronousQueue<String> queue = null;


    public Push(SynchronousQueue<String> queue) {
        this.queue = queue;
    }


    public SynchronousQueue<String> getQueue() {
        return this.queue;
    }


    @Override public void run() {
        while (true) {
            Random random = new Random();
            try {
                String value = String.valueOf(random.nextInt());
                System.out.println("PUSH :: " + value);
                this.queue.put(value);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Pull implements Runnable {
    public SynchronousQueue<String> queue = null;


    public Pull(SynchronousQueue<String> queue) {
        this.queue = queue;
    }


    @Override public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("PULL :: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




class Demo implements Runnable {

    @Override public void run() {
            System.out.println("Hello");
    }
}
