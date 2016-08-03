package com.github.binodnme.dateconverter.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @Author binodnme
 * Created on 4/20/16
 */
@RunWith(JUnitParamsRunner.class)
public class DateBSTest {

  public static final Object[] getParameters() {
    return new Object[] { new Object[] { new DateBS(2073, Month.BAISAKH, 5), new DateBS(2073, Month.BAISAKH, 1), 1 },
            new Object[] { new DateBS(2073, Month.BAISAKH, 5), new DateBS(2073, Month.JESTHA, 1), -1 },
            new Object[] { new DateBS(2073, Month.BAISAKH, 5), new DateBS(2073, Month.BAISAKH, 5), 0 },
            new Object[] { new DateBS(2072, Month.BAISAKH, 5), new DateBS(2071, Month.JESTHA, 23), 1 },
            new Object[] { new DateBS(2073, Month.BAISAKH, 5), new DateBS(2074, Month.ASAR, 1), -1 } };
  }

  @Test
  @Parameters(method = "getParameters")
  public void compareToTest(DateBS dateBS1, DateBS dateBS2, int result) {
    assertEquals(result, dateBS1.compareTo(dateBS2));
  }

//  @Test
//  public void emptyConstructorShouldReturnTodayDate(){
//    DateBS dateBS = new DateBS();
//    DateBS dateBS1 = new DateBS(2073, Month.ASAR, 25);
//    assertEquals(dateBS1, dateBS);
//  }
}
