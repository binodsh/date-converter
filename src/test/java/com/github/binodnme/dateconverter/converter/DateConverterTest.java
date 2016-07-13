package com.github.binodnme.dateconverter.converter;

import com.github.binodnme.dateconverter.utils.CalendarBS;
import com.github.binodnme.dateconverter.utils.DateBS;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
@RunWith(JUnitParamsRunner.class)
public class DateConverterTest {

  private static Object[] getParams() {
    Object[] objects = new Object[15];

    Calendar calendar = Calendar.getInstance();

    calendar.set(1998, Calendar.APRIL, 14);
    objects[0] = new Object[] { calendar.getTime(), new DateBS(2055, CalendarBS.BAISAKH, 1) };

    calendar.set(2007, Calendar.APRIL, 10);
    objects[1] = new Object[] { calendar.getTime(), new DateBS(2063, CalendarBS.CHAITRA, 27) };

    calendar.set(2003, Calendar.JUNE, 13);
    objects[2] = new Object[] { calendar.getTime(), new DateBS(2060, CalendarBS.JESTHA, 30) };

    calendar.set(2000, Calendar.NOVEMBER, 29);
    objects[3] = new Object[] { calendar.getTime(), new DateBS(2057, CalendarBS.MANGSHIR, 14) };

    calendar.set(2005, Calendar.MAY, 30);
    objects[4] = new Object[] { calendar.getTime(), new DateBS(2062, CalendarBS.JESTHA, 17) };

    calendar.set(2016, Calendar.APRIL, 16);
    objects[5] = new Object[] { calendar.getTime(), new DateBS(2073, CalendarBS.BAISAKH, 4) };

    calendar.set(2000, Calendar.FEBRUARY, 9);
    objects[6] = new Object[] { calendar.getTime(), new DateBS(2056, CalendarBS.MAGH, 26) };

    calendar.set(1998, Calendar.APRIL, 16);
    objects[7] = new Object[] { calendar.getTime(), new DateBS(2055, CalendarBS.BAISAKH, 3) };

    calendar.set(1998, Calendar.APRIL, 15);
    objects[8] = new Object[] { calendar.getTime(), new DateBS(2055, CalendarBS.BAISAKH, 2) };

    calendar.set(1968, Calendar.JULY, 26);
    objects[9] = new Object[] { calendar.getTime(), new DateBS(2025, CalendarBS.SHRAWAN, 11) };

    calendar.set(1953, Calendar.APRIL, 23);
    objects[10] = new Object[] { calendar.getTime(), new DateBS(2010, CalendarBS.BAISAKH, 11) };

    calendar.set(2001, Calendar.DECEMBER, 18);
    objects[11] = new Object[] { calendar.getTime(), new DateBS(2058, CalendarBS.POUSH, 3) };

    calendar.set(2023, Calendar.NOVEMBER, 15);
    objects[12] = new Object[] { calendar.getTime(), new DateBS(2080, CalendarBS.KARTIK, 29) };

    calendar.set(2034, Calendar.APRIL, 11);
    objects[13] = new Object[] { calendar.getTime(), new DateBS(2090, CalendarBS.CHAITRA, 28) };

    calendar.set(2041, Calendar.SEPTEMBER, 14);
    objects[14] = new Object[] { calendar.getTime(), new DateBS(2098, CalendarBS.BHADRA, 29) };

    return objects;
  }

  @Test
  @Parameters(method = "getParams")
  public void convertADToBSTest(Date dateAD, DateBS dateBS) {
    DateBS dateBS1 = DateConverter.convertADToBS(dateAD);
    assertEquals(dateBS, dateBS1);
  }

  @Test
  @Parameters(method = "getParams")
  public void convertBSToADTest(Date expectedDate, DateBS inputDateBS) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(expectedDate);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    Date actualDate = DateConverter.convertBSToAD(inputDateBS);
    assertEquals(calendar.getTime(), actualDate);
  }

  @Test
  public void daysBetweenTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2016, Calendar.APRIL, 10);
    DateTime dateTime1 = new DateTime(calendar.getTime());

    calendar.set(2016, Calendar.APRIL, 16);
    DateTime dateTime = new DateTime(calendar.getTime());
    int days = Days.daysBetween(dateTime1, dateTime).getDays();

    assertEquals(6, days);
  }

}