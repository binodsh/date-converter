package com.binodnme.converter;

import com.binodnme.model.CalendarBS;
import com.binodnme.model.DateBS;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
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
    Object[] objects = new Object[6];

    Calendar calendar = Calendar.getInstance();
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

    calendar.set(2016, Calendar.APRIL, 9);
    objects[5] = new Object[] {calendar.getTime(), new DateBS(2072, CalendarBS.CHAITRA, 27)};


    return objects;
  }

  @Test
  @Parameters(method = "getParams")
  public void convertADToBS(Date dateAD, DateBS dateBS){

    DateBS dateBS1 = DateConverter.convertADToBS(dateAD);
    assertEquals(dateBS, dateBS1);
  }
}