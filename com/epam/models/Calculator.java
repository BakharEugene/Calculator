package com.epam.models;

import com.epam.console.input.Reader;
import com.epam.console.output.Writer;

/**
 * Created by Женя on 23.01.2017.
 */
public class Calculator {
    public void run() {
        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.welcomeMessage();
        String expr = "";
        while (expr != "Q") {
            System.out.println("New expression: ");
            expr = reader.read();
            Expression expression = new Expression(expr);

            writer.writeResult(expression.getResult().toString());
        }
    }

}
