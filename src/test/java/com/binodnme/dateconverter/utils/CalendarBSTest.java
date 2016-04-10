package com.binodnme.dateconverter.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
@RunWith(JUnitParamsRunner.class)
public class CalendarBSTest {

  @Test
  public void getDaysInMonthTest() {
    int days = CalendarBS.getDaysInMonth(2055, 11);
    assertEquals(30, days);
  }

  @Test(expected = NullPointerException.class)
  public void getDaysInMonthShouldThrowNullPointerException() {
    CalendarBS.getDaysInMonth(2054, 12);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getDaysInMonthShouldThrowIndexOutOfBoundException() {
    CalendarBS.getDaysInMonth(2055, 12);
  }

  public static final Object[] getParameters() {
    return new Object[] { new Object[] {
            new DateBS(2055, 0, 1), 10, new DateBS(2055, 0, 11) },
            new Object[] { new DateBS(2055, 0, 1), 20, new DateBS(2055, 0, 21) },
            new Object[] { new DateBS(2055, 0, 1), 30, new DateBS(2055, 0, 31) },
            new Object[] { new DateBS(2055, 0, 1), 40, new DateBS(2055, 1, 10) },
            new Object[] { new DateBS(2055, 0, 1), 70, new DateBS(2055, 2, 9) },
            new Object[] { new DateBS(2055, 0, 1), 365, new DateBS(2056, 0, 1) },
            new Object[] { new DateBS(2055, 0, 1), 15, new DateBS(2055, 0, 16) } };
  }

  @Test
  @Parameters(method = "getParameters")
  public void addXDaysTest(DateBS startDate, int daysToAdd, DateBS expectedDate) {
    DateBS dateBS = CalendarBS.addXDays(startDate, daysToAdd);
    assertEquals(expectedDate, dateBS);
  }

  @Test
  @Parameters( method = "getParameters")
  public void daysBetweenTest(DateBS startDate , int expectedDays, DateBS endDate){
    int days = CalendarBS.daysBetween(startDate, endDate);
    assertEquals(expectedDays, days);
  }
}