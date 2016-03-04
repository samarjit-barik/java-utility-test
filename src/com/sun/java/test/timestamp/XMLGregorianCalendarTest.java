package com.sun.java.test.timestamp;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class XMLGregorianCalendarTest {

    public static void main(String ap[]) throws DatatypeConfigurationException {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);


        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        System.out.println(date2);

        Date date3 = date2.toGregorianCalendar().getTime();
        System.out.println(date3);
    }


    public static void testGC() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println("CURREN" + date);
    }
}
