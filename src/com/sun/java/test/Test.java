package com.sun.java.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;


/**
 * Created by sam on 6/19/15.
 */
class MyClass {

    public static <T> T retrieveFutureResult(Future<T> future) throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException ex) {
            Exception sourceException = (Exception)ex.getCause();
            Logger.getGlobal().throwing("Main", "retrieveFutureResult", sourceException);
            return null;
        }
    }

    public static List<Integer> filterUnderThreshold(final List<Integer> values, final int threshold) {
        List<Integer> returnValues = new ArrayList<>(values);
        for (int i = 0; i < returnValues.size(); i++) {
            if (returnValues.get(i) >= threshold) {
                returnValues.remove(i);
            }
        }
        return returnValues;
    }

}


public class Test {

    private String name;


    public static void main(String args[]) {
        Test m1 = new Test();
        Test m2 = new Test();

        m1.name = m2.name = "m1";

        callMe(m1, m2);
        System.out.println(m1 + " & " + m2);

        TreeSet<Integer> c2 = new TreeSet<Integer>();
        c2.add(3);
        c2.add(2);
        c2.add(1);
        c2.add(4);
        doTheThing(new ArrayList<Integer>(Collections.unmodifiableSet(c2)));
    }


    private static void callMe(Test... m) {
        m[0] = m[1];
        m[1].name = "new name";
    }

    private static final int A = 3;

    public static void doTheThing(final Collection<? extends Object> c) {
        c.remove(A);
        System.out.println(c);
    }
}
