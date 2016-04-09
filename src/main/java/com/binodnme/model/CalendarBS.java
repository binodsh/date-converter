package com.binodnme.model;

import com.binodnme.data.Data;

import java.util.Calendar;
import java.util.List;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class CalendarBS {

  public static final int BAISAKH = 0;
  public static final int JESTHA = 1;
  public static final int ASAR = 2;
  public static final int SHRAWAN = 3;
  public static final int BHADRA = 4;
  public static final int ASOJ = 5;
  public static final int KARTIK = 6;
  public static final int MANGSHIR = 7;
  public static final int POUSH = 8;
  public static final int MAGH = 9;
  public static final int FALGUN = 10;
  public static final int CHAITRA = 11;

  public static int getDaysInMonth(int year, int monthIndex) {

    List<Integer> monthsDataInGivenYear = Data.data.get(year);

    if (null != monthsDataInGivenYear) {
      Integer monthData = monthsDataInGivenYear.get(monthIndex);
      if (monthData != null) {
        return monthData;

      } else {
        throw new IndexOutOfBoundsException("month index out of range");

      }
    } else {
      throw new NullPointerException("cannot find the data of year " + year);

    }
  }

  public static DateBS addXDays(DateBS dateBS, int days) {
    if(dateBS == null || days < 0) return null;

    int delta = days;
    int currentYear = dateBS.getYear();
    int currentMonth = dateBS.getMonth();
    int currentDay = dateBS.getDay();


    do {
      int totalDaysInCurrentMonth = Data.data.get(currentYear).get(currentMonth);
      int daysRemainingInCurrentMonth = totalDaysInCurrentMonth - currentDay;

      if (delta <= daysRemainingInCurrentMonth) {
        currentDay += delta;
        delta = 0;
      } else {
        currentDay = 1;
        delta -= daysRemainingInCurrentMonth + 1;

        if (currentMonth == CHAITRA) {
          currentMonth = BAISAKH;
          currentYear += 1;
        } else {
          currentMonth += 1;
        }

      }
    }while (delta > 0);

    return new DateBS(currentYear, currentMonth, currentDay);
  }

}