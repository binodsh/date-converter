package main.java.com.binodnme.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class CalendarBSTest {


  @Test
  public void getDaysInMonthTest(){
    int days = CalendarBS.getDaysInMonth(2055, 11);
    assertEquals(30, days);
  }

  @Test(expected = NullPointerException.class)
  public void getDaysInMonthShouldThrowNullPointerException(){
    CalendarBS.getDaysInMonth(2054, 12);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getDaysInMonthShouldThrowIndexOutOfBoundException(){
    CalendarBS.getDaysInMonth(2055, 12);
  }
}