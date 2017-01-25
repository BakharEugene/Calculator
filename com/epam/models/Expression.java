package com.epam.models;

import com.epam.mathematics.impl.Parser;
import com.epam.mathematics.impl.Result;
import com.epam.validators.impl.DivisionByZeroValidator;
import com.epam.validators.impl.MathematicExpressionValidator;

/**
 * Created by Женя on 23.01.2017.
 */
public class Expression {
    private String expression;
    private Double result;

    public Expression(String expression) {
        this.expression = expression;
        this.result = calculateResult();
    }

    public Double getResult() {
        return result;
    }

    private Double calculateResult() {
        Parser parser = new Parser();
        DivisionByZeroValidator divisionByZeroValidator = new DivisionByZeroValidator();
        if(divisionByZeroValidator.validate(expression)){
            throw new ArithmeticException("Divided by zero");
        }
        String[] param = {expression};

        return (parser.run(param));
    }
}
