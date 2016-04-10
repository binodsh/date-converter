package com.binodnme.dateconverter.converter;

import com.binodnme.dateconverter.utils.CalendarBS;
import com.binodnme.dateconverter.utils.DateBS;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class DateConverter {

  private static Date getReferenceAD() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1998, Calendar.APRIL, 14, 0, 0, 0);
    return calendar.getTime();
  }

  private static DateBS getReferenceBS() {
    return new DateBS(2055, 0, 1);
  }

  public static DateBS convertADToBS(Date date) {
    DateTime startDate = new DateTime(getReferenceAD());
    DateTime endDate = new DateTime(date);
    int daysBetween = Days.daysBetween(startDate, endDate).getDays();

    if (daysBetween < 0) return null;

    return CalendarBS.addXDays(getReferenceBS(), daysBetween);
  }


  public static Date convertBSToAD(DateBS date) {
    DateBS startDate = getReferenceBS();

    int days = CalendarBS.daysBetween(startDate, date);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(getReferenceAD());
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.add(Calendar.DATE, days);

    return calendar.getTime();
  }

}
