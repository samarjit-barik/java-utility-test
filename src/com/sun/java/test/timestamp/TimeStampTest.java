package com.sun.java.test.timestamp;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by sam on 10/23/15.
 */
public class TimeStampTest {

    public static void main (String args[]) throws ParseException {
        long dateInLong = System.currentTimeMillis();
        System.out.println((new Timestamp(dateInLong).toString()));
        Timestamp tsp = getTimestampFromBusinessDay("20150101");
        System.out.println(tsp);

        long current = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current);
        cal.add(Calendar.HOUR, 24);

        System.out.println(new Date(cal.getTimeInMillis()));

        String input = "11/03/2015 23:23:23";
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = dateTimeFormat.parse(input);
        getStartTimeForEachWorker(new Timestamp(date.getTime()), 5);

}

    public static Timestamp getTimestampFromBusinessDay(String businessDay) {
        Timestamp timestamp = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = dateFormat.parse(businessDay);
            Date endDate = new Date(date.getTime() + 86399000);

            timestamp = new Timestamp(endDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timestamp;
    }


    public static List<Timestamp> getStartTimeForEachWorker(Timestamp fromTimestamp,
            int numOfWorkers) {

        Timestamp from = fromTimestamp;
        List<Timestamp> timestamps = new ArrayList<Timestamp>();

        for(int i=0 ;  i<numOfWorkers; i++ ) {
            // The very first StartTime would be the last Run Date from DB
            if(timestamps.size() == 0) {
                timestamps.add(from);
            } else {
                Timestamp nextTimestamp = getNextTimestamp(from);
                timestamps.add(nextTimestamp);
                from = nextTimestamp;
            }
        }
        System.out.println(timestamps);
//        Date fromDate = trim(new Date(from.getTime()));
//
//        long current = System.currentTimeMillis();
//        Timestamp getCurrentTimeStampFromDB = new Timestamp(current);
//
//        Date currentDate = trim(new Date(current));
//
//        System.out.println("fromDate :: " + fromDate);
//        System.out.println("currentDate :: " + currentDate);
//        System.out.println(fromDate.compareTo(currentDate));
//
//        if (fromDate.before(currentDate)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//
//        System.out.println(getNextDate(currentDate));
        return null;
    }

    public static Timestamp getNextTimestamp(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        Date nextDate = getNextDate(trim(date));

        return new Timestamp(nextDate.getTime());
    }

    public static Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);

        return calendar.getTime();
    }

    public static Date getNextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 24);
        return calendar.getTime();
    }


}
