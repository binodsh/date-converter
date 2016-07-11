package com.binodnme.main;

import com.binodnme.dateconverter.converter.DateConverter;
import com.binodnme.dateconverter.utils.DateBS;

import java.util.Date;

/**
 * @Author kaala on 7/11/16.
 */
public class Main {
    /**
     * main method
     * @param args string args
     */
    public static void main(String[] args){
        DateBS dateBS = new DateBS();
        Date date = DateConverter.convertBSToAD(dateBS);
        System.out.println(date);
    }
}
