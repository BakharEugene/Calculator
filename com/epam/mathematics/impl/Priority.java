package com.epam.mathematics.impl;

import com.epam.mathematics.Operation;

/**
 * Created by Женя on 23.01.2017.
 */
public class Priority implements Operation<Byte, Character> {
    @Override
    public Byte run(Character[] args) {
        switch (args[0]) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }
}
