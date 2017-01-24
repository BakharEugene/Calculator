package com.epam.mathematics.impl;

import com.epam.mathematics.Operation;

/**
 * Created by Женя on 23.01.2017.
 */
public class Result implements Operation<Double, String> {
    @Override
    public Double run(String[] args) {
        Double first = Double.parseDouble(args[0]);
        Double second = Double.parseDouble(args[1]);
        Character operation = args[2].charAt(0);

        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '%':
                return first % second;
            case '/':
                if (second != 0) {
                    return first / second;
                } else {
                    throw new ArithmeticException("Divided by zero");

                }
            case '^':
                return Math.pow(first, second);
            default:
                return 0.0;
        }

    }
}
