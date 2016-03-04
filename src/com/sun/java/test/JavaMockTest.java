package com.sun.java.test;


/**
 * Created by sam on 2/22/16.
 */
public class JavaMockTest {

    int z;


    public static void main(String[] args) {
        JavaMockTest myScope = new JavaMockTest();
        int z = 6;
        System.out.println(z);
        myScope.doStuff();
        System.out.println(z);
        System.out.println(myScope.z);

//        int[][] array2D = {{0, 1, 2, 4},{5, 6}};
//        int[][][] array3D = {{0, 1}, {2, 3}, {4, 5}};

//        int[][] array2D = new int[2][2];
//        array2D[0][0] = 1;
//        array2D[0][1] = 2;
//        array2D[1][0] = 3;
//        array2D[1][1] = 4;

//        int[][][] array3D = new int[2][2][2];
//        array3D[0][0] = array;
//        array3D[0][1] = array;
//        array3D[1][0] = array;
//        array3D[0][1] = array;

        int value = 33;
        if (value >= 0) {
            if (value != 0)
                System.out.print("The ");
            else
                System.out.print("quick ");
            if (value < 10)
                System.out.print("brown ");
            if (value > 30)
                System.out.print("fox ");
            else if (value < 50)
                System.out.print("jumps ");
            else if (value < 10)
                System.out.print("over ");
            else
                System.out.print("the ");
            if (value > 10)
                System.out.print("lazy ");
        } else {
            System.out.print("dog ");
        }
        System.out.print("... ");

        System.out.println("Result: " + 2 + 3 + 5);
        System.out.println("Result: " + 2 + 1 * 5);

        //Boolean array[3];
        //Float[2] array;

        //int[] array;
        //Object array[];

        int[][] array2D = {{0, 1, 2}, {3, 4, 5, 6}};
        System.out.print(array2D[0].length + "");
        System.out.print(array2D[1].getClass().isArray() + "");
        System.out.println(array2D[1][2]);

        StringBuilder sb = new StringBuilder();

        sb.
    }


    void doStuff() {
        int z = 5;
        doStuff2();
        System.out.println(z);
    }


    void doStuff2() {
        z = 4;
    }
}
