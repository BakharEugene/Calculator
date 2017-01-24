package com.epam.models;

import com.epam.console.input.Reader;
import com.epam.console.output.Writer;

/**
 * Created by Женя on 23.01.2017.
 */
public class Calculator {
    public void run() {
        Reader reader = new Reader();
        String expr = reader.read();
        Expression expression = new Expression(expr);
        Writer writer=new Writer();
        writer.writeResult(expression.getResult().toString());
    }

}
