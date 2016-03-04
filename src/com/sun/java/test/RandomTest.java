package com.sun.java.test;


import java.util.Random;


/**
 * Created by sam on 10/16/15.
 */
public class RandomTest {

    public static void main(String arg[]) {
        Random r = new Random(System.currentTimeMillis());
        System.out.println(r.toString());
        System.out.println(10000 + r.nextInt(20000));

        String txnId = "20151015R1234567890";
        String bizDateStr = txnId.substring(0, 8);
        System.out.println(bizDateStr);


    }


}
