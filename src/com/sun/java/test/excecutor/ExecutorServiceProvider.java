package com.sun.java.test.excecutor;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Created by sam on 9/24/15.
 */
public class ExecutorServiceProvider {
    public static ExecutorService getExecutorService() {
        return Executors.newCachedThreadPool();
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //Coordinator co = new Coordinator();
        //getExecutorService().submit(co);

        ExecutorService execService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        for(int i = 1; i <=5 ; i++) {
            futures.add(execService.submit(new CallableUserTask(i)));
        }


        for(Future<Integer> future : futures) {
            if(future.isDone()) {
                System.out.println("Future Job" + future.get());
            } else {
                System.out.println("Future Job Still Running ....");
            }
        }

    }

}

class CallableUserTask implements Callable<Integer> {
private int jobNumber;


    public CallableUserTask(int jobNo) {
        this.jobNumber = jobNo;
    }


    @Override
    public Integer call() throws Exception {
        System.out.println("Callable Job :: " + jobNumber + " :: Start");

        int max = 10000;
        int min = 1000;

        Random random = new Random();
        int sleep = random.nextInt(max -min) + min;
        System.out.println("Sleep :: " + sleep);
        Thread.sleep(sleep);
        System.out.println("Callable Job :: " + jobNumber + " :: End");
        return jobNumber;
    }
}
