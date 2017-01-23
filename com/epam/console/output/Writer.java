package com.epam.console.output;

/**
 * Created by Женя on 23.01.2017.
 */
public class Writer implements Writable{
    @Override
    public void writeResult(String expression) {
        System.out.println(expression);
    }
}
