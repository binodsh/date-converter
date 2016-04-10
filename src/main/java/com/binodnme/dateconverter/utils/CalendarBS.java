package com.binodnme.dateconverter.utils;

import com.binodnme.dateconverter.data.Data;

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
    if (dateBS == null || days < 0)
      return null;

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
    } while (delta > 0);

    return new DateBS(currentYear, currentMonth, currentDay);
  }

  public static int daysBetween(DateBS startDate, DateBS endDate) {
    int totalDays = 0;
    int year = startDate.getYear();
    int month = startDate.getMonth();

    while (!((year == endDate.getYear()) && (month == endDate.getMonth()))) {
      if (month == CHAITRA) {
        totalDays += Data.data.get(year).get(month);
        year++;
        month = BAISAKH;
      } else {
        totalDays += Data.data.get(year).get(month);
        month++;
      }
    }
    totalDays += (endDate.getDay() - startDate.getDay());
    return totalDays;
  }
}