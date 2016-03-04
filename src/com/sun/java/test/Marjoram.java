package com.sun.java.test;


/**
 * Created by sam on 6/17/15.
 */
//public class TreadTest implements Runnable {
//
//    public static void main(String[] args) {
//        TreadTest p = new TreadTest();
//        Thread t1 = new Thread(p);
//        Thread t2 = new Thread(p);
//        t1.start();
//        t2.start();
//        t1.start();
//    }
//
//
//    public void run() {
//        System.out.print("x");
//    }
//}


import java.util.Objects;


/**************************************************************************/


//import java.util.*;
//
//
//public class NavMap {
//    public static void main(String[] args) {
//        TreeMap<String, Integer> myMap = new TreeMap<String, Integer>();
//        myMap.put("ak", 50);
//        myMap.put("co", 60);
//        myMap.put("ca", 70);
//        myMap.put("ar", 80);
//        NavigableMap<String, Integer> myMap2 = myMap.headMap("ca", true);
//        System.out.println(myMap2.get("ak") + " " + myMap2.get("co"));
//    }
//}

////**************************************************************************************************
//public class Marjoram {
//    public static void main(String[] args) {
//        Marjoram g = new Marjoram();
//        System.out.print(g.go(1));
//    }
//
//
//    <A extends Alpha> Alpha go(int i) {
//        if (i == 1)
//            return new Alpha();
//        else
//            return new Beta();
//    }
//}
//
//
//class Alpha {
//}
//
//
//class Beta extends Alpha {
//}
//
//
//
////**************************************************************************************************
//class Book {
//    private final void read() {
//        System.out.print("book ");
//    }
//}
//
//
//class Page extends Book {
//    public static void main(String[] args) {
//        new Page().read();
//        new Book().read();
//    }
//
//
//    private final void read() {
//        System.out.print("page ");
//    }
//}

////**************************************************************************************************
class NoGo implements Runnable {
    private static int i;


    public synchronized void run() {
        if (i % 10 != 0) {
            i++;
        }
        for (int x = 0; x < 10; x++, i++) {
            if (x == 4)
                Thread.yield();
        }
    }


    public static void main(String[] args) {
        NoGo n = new NoGo();
        for (int x = 0; x < 101; x++) {
            new Thread(n).start();
            System.out.println(i + " ");
        }
    }
}

////**************************************************************************************************
//01     class HorseRadish {
//    02          // insert code here
//            03          protected HorseRadish(int x) {
//        04               System.out.println("bok choy");
//        05          }
//    06     }
//07     class Wasabi extends HorseRadish {
//    08          public static void main(String [] args) {
//        09               Wasabi w = new Wasabi();
//        10          }
//    11     }
////**************************************************************************************************
//class CopyArray {
//    public static void main(String [] args) {
//        int[] x = {1, 2 ,3};
//        int[] y = {4, 5, 6, 7};
//        System.arraycopy(x, 1, y, 2, 2);
//        for(int var : y) {
//            System.out.print(var +" ");
//        }
//    }
//}
//
////**************************************************************************************************
//01     Date d = new Date(1700000000000L);
//        02     System.out.println(d.toString()); // output line 1
//        03     Calendar c1 = Calendar.getInstance();
//        04     c1.setTime(d);
//        05     Calendar c2 = Calendar.getInstance();
//        06     c2.setTime(d);
//        07     c1.add(Calendar.MONTH, 10);
//        08     c2.roll(Calendar.MONTH, 10);
//        09     System.out.println(c1.getTime().toString());
//        10     System.out.println(c2.getTime().toString());
//
////**************************************************************************************************
