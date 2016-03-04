package com.sun.java.test.timestamp;


import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * Created by sam on 12/7/15.
 */
public class TimeTest {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-kkmmss");


    public static void main(String args[]) {
        String dateStr = "20151202-000000";

        int num = 1;

        try {
            try {
                if (num == 1)
                    throw new RuntimeException();
            } finally {
                System.out.println("finally");
            }

            System.out.println("Inner try after finally");
        } catch (Exception e) {
            System.out.println("Outer....Catch");
        }

    }

}
