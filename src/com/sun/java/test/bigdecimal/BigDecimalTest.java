package com.sun.java.test.bigdecimal;


import static com.apple.pos.shared.data.DataUtils.pair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.jvmstat.perfdata.monitor.AliasFileParser;


/**
 * Created by sam on 12/23/15.
 */
public class BigDecimalTest {

    public static void main(String a[]) {

        BigDecimal num = new BigDecimal("0.00");

        if (num.equals(BigDecimal.ZERO)) {
            System.out.println("num=" + num);
        }

        List<String> aList = new ArrayList<String>();
        aList.add("AAA");
        aList.add("BBB");
        aList.add("CCC");
        aList.add("DDD");
        aList.add("EEE");

        List<String> bList = new ArrayList<String>();
        bList.add("AAA");
        bList.add("BBB");
        bList.add("CCC");
        bList.add("FFF");
        bList.add("GGG");
        bList.add("HHH");

        Set<String> aSet = new HashSet<String>();

        aSet.addAll(aList);
        System.out.println(aSet);

        aSet.addAll(bList);

        System.out.println("aSet Size=" + aSet.size());

        System.out.println(aSet);
        List<String> l = new ArrayList<String>(aSet);
        Collections.sort(l);
        System.out.println(l);

        DropTest dpTest = new DropTest();
        dpTest.setStart(100);
        dpTest.setEnd(101);

        System.out.println(dpTest);
    }
}


class DropTest {
    private int start;
    private int end;


    public String toString() {
        // System.out.println(this);
        StringBuffer sb = new StringBuffer();

        sb.append("JOB").append(pair("Start", start)).append(" ").append(pair("End", end));
        //String str = ""+pair("Start", start) +" " +pair("End", end);

        return sb.toString();
    }


    public int getStart() {
        return start;
    }


    public void setStart(int start) {
        this.start = start;
    }


    public int getEnd() {
        return end;
    }


    public void setEnd(int end) {
        this.end = end;
    }
}
