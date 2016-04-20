package com.binodnme.dateconverter.utils;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class DateBS implements Comparable {
  private int year;
  private int month;
  private int day;

  public DateBS(int year, int month, int day) {
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
    if (!(obj instanceof DateBS)) {
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

  @Override
  public int compareTo(Object o) {
    if (!(o instanceof DateBS)) return 0;

    if(this.year > ((DateBS) o).getYear()){
      return 1;
    }else if (this.year < ((DateBS) o).getYear()){
      return -1;
    }else if(this.month > ((DateBS) o).getMonth()){
      return 1;
    }else if(this.month < ((DateBS) o).getMonth()){
      return -1;
    }else if(this.day > ((DateBS) o).getDay()){
      return 1;
    }else if(this.day < ((DateBS) o).getDay()){
      return -1;
    }else {
      return 0;
    }
  }
}
