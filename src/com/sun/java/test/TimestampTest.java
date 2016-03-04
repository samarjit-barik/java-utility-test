package com.sun.java.test;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by sam on 10/2/15.
 */
public class TimestampTest {
    public static void main(String args[]) throws DatatypeConfigurationException {

        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp.getTime() + " = " + date.getTime());

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-kkmmss");


        System.out.println(
                timestamp.toString() + " :: " + dateFormat.format(new Date(timestamp.getTime())));

        Date dated = new Date(System.currentTimeMillis() -100000000000l);
        System.out.println(dated);

        GregorianCalendar gCalder = new GregorianCalendar();
        gCalder.setTime(dated);
        System.out.println(gCalder);
        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                gCalder);
        System.out.println(calendar);
        GregorianCalendar gCal2 = calendar.toGregorianCalendar();
        System.out.println(gCal2);
        System.out.println(gCal2.getTime());
    }
}
