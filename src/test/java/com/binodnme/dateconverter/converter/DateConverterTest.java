package com.binodnme.dateconverter.converter;

import com.binodnme.dateconverter.utils.CalendarBS;
import com.binodnme.dateconverter.utils.DateBS;
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

  private static Object[] getParams(){
    Object[] objects = new Object[7];

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    calendar.set(1998, Calendar.APRIL, 14);
    objects[0] = new Object[] {calendar.getTime(), new DateBS(2055, CalendarBS.BAISAKH, 1)};

    calendar.set(2007, Calendar.APRIL, 10);
    objects[1] = new Object[] {calendar.getTime(), new DateBS(2063, CalendarBS.CHAITRA, 27)};

    calendar.set(2003, Calendar.JUNE, 13);
    objects[2] = new Object[] {calendar.getTime(), new DateBS(2060, CalendarBS.JESTHA, 30)};

    calendar.set(2000, Calendar.NOVEMBER, 29);
    objects[3] = new Object[] {calendar.getTime(), new DateBS(2057, CalendarBS.MANGSHIR, 14)};

    calendar.set(2005, Calendar.MAY, 31);
    objects[4] = new Object[] {calendar.getTime(), new DateBS(2062, CalendarBS.JESTHA, 17)};

    calendar.set(2016, Calendar.APRIL, 16);
    objects[5] = new Object[] {calendar.getTime(), new DateBS(2073, CalendarBS.BAISAKH, 4)};

    calendar.set(2000, Calendar.FEBRUARY, 9);
    objects[6] = new Object[] {calendar.getTime(), new DateBS(2056, CalendarBS.MAGH, 26)};

    return objects;
  }

  @Test
  @Parameters(method = "getParams")
  public void convertADToBSTest(Date dateAD, DateBS dateBS){
    DateBS dateBS1 = DateConverter.convertADToBS(dateAD);
    assertEquals(dateBS, dateBS1);
  }

  @Test
  @Parameters(method = "getParams")
  public void convertBSToADTest(Date expectedDate, DateBS inputDateBS){
    Date actualDate = DateConverter.convertBSToAD(inputDateBS);
    assertEquals(expectedDate, actualDate);
  }

  @Test
  public void daysBetweenTest(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(2016, Calendar.APRIL, 10);
    DateTime dateTime1 = new DateTime(calendar.getTime());

    calendar.set(2016, Calendar.APRIL, 16);
    DateTime dateTime = new DateTime(calendar.getTime());
    int days = Days.daysBetween(dateTime1, dateTime).getDays();

    assertEquals(6, days);
  }

}