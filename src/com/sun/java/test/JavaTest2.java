package com.sun.java.test;

import java.util.*;

import java.io.File;


/**
 * Created by sam on 6/17/15.
 */
class JavaTest2 {
    public static void main(String[] args) {
        boolean b1 = false;
        boolean b2 = true;
        if (b1 ^ b2)
            System.out.println("Red");
        else if (b1 & b2)
            System.out.println("Green");
        else
            System.out.println("Yellow");

        if (true | false) {
            System.out.println("1");
        } else if (true & false) {
            System.out.println("2");
        }

        Wasabi w = new Wasabi();

        Date d = new Date(1700000000000L);
        System.out.println(d.toString()); // output line 1
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d);
        c1.add(Calendar.MONTH, 10);
        c2.roll(Calendar.MONTH, 10);
        System.out.println(c1.getTime().toString());
        System.out.println(c2.getTime().toString());

    }




}


class HorseRadish {
    // insert code here
    protected HorseRadish() {
        new HorseRadish(42);
    }


    protected HorseRadish(int x) {
        System.out.println("bok choy");
    }
}


class Wasabi extends HorseRadish {

}


class YaYa {
    Yum yum;
}


interface Yum {
    void yip();
}


class Fizz extends YaYa implements Yum {
    public void yip() {
    }
}


interface Zoom extends Yum {
}


class MyInfo implements Comparable<MyInfo> {
    MyInfo(String s) {
        desc = s;
    }


    String desc;


    // insert code here
    public String toString() {
        return desc;
    }


    @Override public int compareTo(MyInfo o) {
        return desc.compareTo(o.toString()); }

}


class SuperFoo {
    SuperFoo doStuff(int x) {
        return new SuperFoo();
    }
}


class Foo extends SuperFoo {
    SuperFoo doStuff(Integer x) { return new Foo(); }}
