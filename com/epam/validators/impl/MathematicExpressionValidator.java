package com.epam.validators.impl;

import com.epam.validators.Validator;

import java.util.regex.Pattern;

/**
 * Created by Женя on 25.01.2017.
 */
public class MathematicExpressionValidator implements Validator {
    @Override
    public boolean validate(String expr) {
        return Pattern.matches("\\s*\\(*\\s*(-?\\d+|-?\\d+\\.\\d+)(\\s*[-+ */^]\\(*\\s*-?(\\d+|-?\\d+\\.\\d+)\\s*\\)*)*\\s*", expr);
    }
}
