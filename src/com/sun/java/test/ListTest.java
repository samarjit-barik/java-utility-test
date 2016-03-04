package com.sun.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by sam on 7/29/15.
 */
public class ListTest {

    public static void main (String a[]) {
        List<Integer> numList1 = new ArrayList<>();
        numList1.add(1);
        numList1.add(2);
        numList1.add(3);

        Set<Integer> numList2 = new HashSet<>();
        numList2.add(1);
        numList2.add(2);
        numList2.add(3);
        numList2.add(4);
        numList2.add(5);


        System.out.println(numList2.addAll(numList1) + "::" + numList2);

    }
}
