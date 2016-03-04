package com.sun.java.test;


import java.util.HashMap;
import java.util.Map;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public class EnumTest {

    public static void main(String args[]) {

        //System.out.println(null != EnumTestCtr.valueOf("A2"));
        System.out.println(DUMMY.DUMMY1.toString());
        System.out.println(DUMMY.DUMMY2.toString());

    }

    public enum DUMMY {
        DUMMY1,
        DUMMY2;
    }

    public enum EnumTestCtr {
        OPEN_STORE(1),
        REG_OPEN(2),
        TILL_OPEN(3),
        BK_SALE_RETURN_TXN(4),
        DEFAULT(5),
        CLOSE_STORE(99);

        private final int priority;
        private static final Map<Integer, EnumTestCtr> transactionPriorityMap;


        private EnumTestCtr(int priority) {
            this.priority = priority;
        }


        public EnumTestCtr getTransactionPriority(int priority) {
            return (EnumTestCtr) transactionPriorityMap.get(Integer.valueOf(priority));
        }


        public int getPriorityCode() {
            return this.priority;
        }


        static {
            transactionPriorityMap = new HashMap();
            EnumTestCtr[] arr$ = values();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                EnumTestCtr value = arr$[i$];
                transactionPriorityMap.put(Integer.valueOf(value.getPriorityCode()), value);
            }

        }
    }
}

