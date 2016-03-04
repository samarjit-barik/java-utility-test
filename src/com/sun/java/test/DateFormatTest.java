package com.sun.java.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by sam on 11/2/15.
 */
public class DateFormatTest {

    public static void main(String[] args) {
        //String input = "11/03/2015";
        String input = "11/03/2015 23:23:23";

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        SimpleDateFormat updatedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat updatedDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        boolean requiredFormatFound = false;
        Date date = null;

        try {
            date = dateFormat.parse(input);

            if(input.equals(dateFormat.format(date))) {
                requiredFormatFound = true;
                System.out.println("DateFormat is :: " + dateFormat.toPattern());

                System.out.println(updatedDateFormat.format(date));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            if(!requiredFormatFound) {
                date = dateTimeFormat.parse(input);

                if(input.equals(dateTimeFormat.format(date))) {
                    System.out.println("DateFormat is :: " + dateTimeFormat.toPattern());
                    System.out.println(updatedDateTimeFormat.format(date));
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
