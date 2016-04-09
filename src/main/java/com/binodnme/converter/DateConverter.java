package com.binodnme.converter;

import com.binodnme.model.DateBS;
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
    return new DateBS(2055, 1, 1);
  }

//  public static DateBS convertADToBS(Date date) {
//    DateTime startDate = new DateTime(getReferenceAD());
//    DateTime endDate = new DateTime(date);
//    int daysBetween = Days.daysBetween(startDate, endDate).getDays();
//  }

}
