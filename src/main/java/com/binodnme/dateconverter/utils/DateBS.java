package com.binodnme.dateconverter.utils;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class DateBS {
  int year;
  int month;
  int day;

  public DateBS(int year, int month, int day){
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof DateBS)){
      return false;
    }
    DateBS date = (DateBS) obj;
    return this.year == date.year && this.month == date.month && this.day == date.day;
  }

  @Override
  public String toString() {
    return "DateBS{" +
            "year=" + year +
            ", month=" + month +
            ", day=" + day +
            '}';
  }
}
