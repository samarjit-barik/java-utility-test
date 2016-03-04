package com.sun.java.test.enumer;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by sam on 10/1/15.
 */
public class EnumTest {


    public static void main(String args[]) {

        System.out.println(Test.getMap().get(Test.TEST1));

    }
}



enum Test {
    TEST1,
    TEST2;

    private static Map<Test, String> enumMap = new HashMap<Test, String>();

    static {
        for(Test test : Test.values()) {
            enumMap.put(test, "I am a BakCh**d");
        }
    }

    public static Map<Test, String> getMap() {
        return enumMap;
    }
}
