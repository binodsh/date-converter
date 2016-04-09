package main.java.com.binodnme.model;

import main.java.com.binodnme.data.Data;

import java.util.List;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class CalendarBS {

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
}