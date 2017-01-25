package com.epam.validators.impl;

import com.epam.validators.Validator;

import java.util.regex.Pattern;

/**
 * Created by Женя on 25.01.2017.
 */
public class DivisionByZeroValidator implements Validator {
    @Override
    public boolean validate(String expr) {
        return Pattern.matches(".+\\/\\s*0[\\+\\-\\*/^()]*([^\\.]*)", expr  );
    }
}
