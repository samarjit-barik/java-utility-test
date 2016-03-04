package com.sun.java.test;


import java.math.BigInteger;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by sam on 6/11/15.
 */
public class ABCException<T extends Exception> {

    private void pleaseThrow(final Exception t) throws T {

        T te = (T) t;
        throw te;
    }


    public static void main(String args[]) {
        try {
            //new ABCException<RuntimeException>().pleaseThrow(new SQLException());
            //System.out.print(getIPv4BinaryRepresentation("17.114.53.27"));


            //Map<int, int> map = new TreeMap<int, int>();
            System.out.print(parsePriceTotalOfProducts("1265"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BigInteger parsePriceTotalOfProducts(final String input) {
        //example input: 'bought 9 products for 120 per piece'
        //this method assumes that prices are input as integers, so '1265' instead of '1.265,00'
        Pattern pattern = Pattern.compile("/^.*?(d+).+?(d+).*$");
        Matcher matcher = pattern.matcher(input);
        int number = Integer.parseInt(matcher.group(1));
        int costPerProduct = Integer.parseInt(matcher.group(2));
        return BigInteger.valueOf((long)number * costPerProduct);
    }

    //    public static int getIPv4BinaryRepresentation(final String ipv4) {
    //        Matcher matcher = Pattern.compile("/^([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.([1-9]?\\d|1\\d\\d|2[0-4]\\d|25[0-5])$/").matcher(ipv4);
    //        if (!matcher.find()) {
    //            throw new IllegalArgumentException("Not an IPv4 address: " + ipv4);
    //        }
    //        int p1 = Integer.parseInt(matcher.group(1));
    //        int p2 = Integer.parseInt(matcher.group(2));
    //        int p3 = Integer.parseInt(matcher.group(3));
    //        int p4 = Integer.parseInt(matcher.group(4));
    //        if (p1 < 0 || p1 > 255 || p2 < 0 || p2 > 255 || p3 < 0 || p3 > 255 || p4 < 0 || p4 > 255) {
    //            throw new IllegalArgumentException("Not an IPv4 address: " + ipv4);
    //        }
    //        return ((p1 << 24) | (p2 << 16) | (p3 << 8) | p4);
    //    }

}
