package com.epam.validators.impl;

import com.epam.validators.Validator;

import java.util.Stack;

/**
 * Created by Женя on 25.01.2017.
 */
public class ParenthesisValidator implements Validator {
    @Override
    public boolean validate(String expr) {
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                parenthesisStack.push('(');
            }
            if (expr.charAt(i) == ')') {
                if (parenthesisStack.isEmpty()) {
                    return false;
                }
                parenthesisStack.pop();
            }
        }
        return parenthesisStack.isEmpty();    }
}
