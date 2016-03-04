package com.sun.java.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;


/**
 * Created by sam on 4/15/15.
 */
public class JavaTest {
    public static void main(String[] args) {
        //******************************************************
        //System.out.println("Hello World");
//        List<String> salesOrgIdList = new ArrayList<String>();
//        salesOrgIdList.add("SAMAR");
//        salesOrgIdList.add("SAMAR");
//        salesOrgIdList.add("SAMAR");
//        salesOrgIdList.add("SAMAR");
//        salesOrgIdList.add("SAMAR");
//        salesOrgIdList.add("SAMAR");
//
//        ExecutorService exec = Executors.newFixedThreadPool(10);
//
//   /*     Collection<Future<?>> fs = new ArrayList<Future<?>>();
//        int count = 0;
//        for (String salesOrgId : salesOrgIdList) {
//            final String fSaleOrgId = salesOrgId.trim() + count++;
//            fs.add(exec.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(fSaleOrgId);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }));
//        }
//
//        for (Future<?> f : fs) {
//            try {
//                f.get();
//            } catch (InterruptedException e) {
//                //throw new ItemServiceException("refresh cache got interrupted", e);
//            } catch (ExecutionException e) {
//                //throw new ItemServiceException("refresh cache error:", e.getCause());
//            }
//        }
//*/
//        Collection<Future<String>> fsString = new ArrayList<Future<String>>();
//        int count = 0;
//        for (String salesOrgId : salesOrgIdList) {
//            final String fSaleOrgId = salesOrgId.trim() + count++;
//            fsString.add(exec.submit(new Callable<String>() {
//                @Override public String call() throws Exception {
//                    //System.out.println(fSaleOrgId);
//                    return fSaleOrgId + "Hello";
//                }
//            }));
//        }
//
//        System.out.println(fsString.size());
//
//        for (Future<String> f : fsString) {
//            try {
//                System.out.println(f.get());
//            } catch (InterruptedException e) {
//                //throw new ItemServiceException("refresh cache got interrupted", e);
//            } catch (ExecutionException e) {
//                //throw new ItemServiceException("refresh cache error:", e.getCause());
//            }
//        }
        //******************************************************

        Map<Integer, Integer> numbers = new TreeMap<>();

        int top = 10;

        for (int i = 0; i < top; i++)
            numbers.put(i, i);

        System.out.println(sum(numbers.get(top), top));

        Map<String, Object> collection = new TreeMap<>();

        //System.out.println( collection.compute( "foo", (k, v) -> (v == null) ? new ArrayList<Object>() : ((List)v).add( "bar" ) ) );
        //System.out.println( collection.compute( "foo", (k, v) -> (v == null) ? new ArrayList<Object>() : ((List)v).add( "ber" ) ) );
    }


    public static <T> List<T> getFlattenedList(final List<List<T>> lists) {
        List<T> flattenedList = new ArrayList<>();
        for (List<T> list : lists) {
            for (T element : list) {
                flattenedList.add(element);
            }
        }
        return flattenedList;
    }


    private static int sum(int a, int b) {
        return a + b;
    }


    private long getSequenceRange(long lastSequenceNumber, int batchSize, int numOfWorkers) {
        int range = batchSize * numOfWorkers;
        long maxSequenceNumber = lastSequenceNumber + range;
        return maxSequenceNumber;
    }

}
