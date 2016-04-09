package main.java.com.binodnme.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author binodnme
 * Created on 4/9/16
 */
public class Data {
  public static HashMap<Integer, List<Integer>> data =
          new HashMap<Integer, List<Integer>>(){
            {
              put(2055, Arrays.asList(31,31,32,31,31,31,30,29,30,29,30,30));
              put(2056, Arrays.asList(31,31,32,31,32,30,30,29,30,29,30,30));
              put(2057, Arrays.asList(31,32,31,32,31,30,30,30,29,29,30,31));
              put(2058, Arrays.asList(30,32,31,32,31,30,30,30,29,30,29,31));
              put(2059, Arrays.asList(31,31,32,31,31,31,30,29,30,29,30,30));
              put(2060, Arrays.asList(31,31,32,32,31,30,30,29,30,29,30,30));
              put(2061, Arrays.asList(31,32,31,32,31,30,30,30,29,29,30,31));
              put(2062, Arrays.asList(31,31,31,32,31,31,29,30,29,30,29,31));
              put(2063, Arrays.asList(31,31,32,31,31,31,30,29,30,29,30,30));
              put(2064, Arrays.asList(31,31,32,32,31,30,30,29,30,29,30,30));
            }
          };
}
