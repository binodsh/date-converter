package com.github.binodnme.dateconverter.utils;

/**
 * @author kaala on 8/3/16.
 */
public enum  Month {
    BAISAKH(0),
    JESTHA(1),
    ASAR(2),
    SHRAWAN(3),
    BHADRA(4),
    ASOJ(5),
    KARTIK(6),
    MANGSHIR(7),
    POUSH(8),
    MAGH(9),
    FALGUN(10),
    CHAITRA(11);

    private static Month[] vals = values();

    private int value;

    Month(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public Month next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
