package com.sun.java.test.excecutor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;


/**
 * Created by sam on 9/23/15.
 */
public class ExecuterTest {
    public static void main(String a[]) {
        //System.out.print("Hello world");

        ExecutorService service = Executors.newCachedThreadPool();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int count =0;
                ExecutorService service = Executors.newCachedThreadPool();
                boolean status = true;
                while(status) {
                    //System.out.println("Hello");
                    try {
//                        System.out.println(count + " ➜ " +new Date());
//                        try{
//                            //Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            System.out.println("InterruptedException" + e);
//
//                        }


                        List<Future<String>> futures = new ArrayList<Future<String>>();

                        int count1 = 0;
                        for(;;){
                            futures.add(service.submit(new Callable<String>() {
                                @Override
                                public String call() {
                                    String threadName = Thread.currentThread().getName();
                                    try {
                                        System.out.println(threadName + " Started...");
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        System.out.println(Thread.currentThread().getName() + e);
                                        //throw new RuntimeException(e.getMessage() + Thread.currentThread().isInterrupted(), e);
                                    }

                                    return Thread.currentThread().getName() + " ➜ completed ➜ " +  Thread.currentThread().isInterrupted();
                                }
                            }));
                            count1++;
                            if(count1 == 5) {
                                break;
                            }
                        }

//                        for(Future<String> future : futures) {
//                            try {
//                                System.out.println(future.get());
//                            } catch (InterruptedException e) {
//                                System.out.println(e);
//                                System.out.println(Thread.currentThread().getName() + " :: InterruptedException");
//                                status = false;
//                            } catch (ExecutionException e) {
//                                e.printStackTrace();
//                            }
//                        }

                        try{
                            for(Future<String> future : futures) {
                                System.out.println(future.get());
                            }
                        } catch (InterruptedException e) {
                            System.out.println(e);
                            System.out.println(Thread.currentThread().getName() + " :: InterruptedException");
                            status = false;
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Thread.currentThread().isInterrupted() ➜ " + Thread.currentThread().isInterrupted());
                    } catch (Exception e) {
                        System.out.println("Exception" + e);
                    } finally {
                        //service.shutdown();
                    }
                    count++;
                }
            }
        };

        Future<?> future = service.submit(runnable);

        System.out.println(service.shutdownNow());

        System.out.println("service.isTerminated()➜" + service.isTerminated());
        System.out.println("service.isShutdown()➜" + service.isShutdown());

        //service.submit(runnable);



//        int count=0;
//        while(true) {
//            if(count == 10) {
//                System.out.println("Shutting the service down");
//
//                //future.cancel(true);
//                service.shutdownNow();
//                System.out.println("service.isTerminated() after shutdown➜" + service.isTerminated());
//                System.out.println("service.isShutdown() after shutdown➜" + service.isShutdown());
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            count++;
//        }



        //service.submit(runnable);

//        Collection<Future<String>> fs = new ArrayList<>();
//        fs.add(service.submit(new Job()));
//
//        for (Future<String> f : fs) {
//            try {
//                f.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//
        //ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(5);
        //
        //Callable<String> call = new Callable() {
        //    @Override public String call() throws Exception {
        //        System.out.println("Hello");
        //
        //        return "SAMAR";
        //    }
        //};

        //scheduledService.scheduleWithFixedDelay(runnable, 0, 5, TimeUnit.SECONDS);
        //scheduledService.
        //scheduledService.submit(call);
    }
}


class TestExecutor implements Runnable {

    @Override public void run() {
        System.out.println(
                "Execute thread :: " + new Date() + " : :" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Job implements Callable<String> {

    @Override public String call() throws Exception {
        throw new IllegalArgumentException("Argument not valid");
    }
}
