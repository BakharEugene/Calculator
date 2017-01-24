package com.epam.models;

import com.epam.mathematics.impl.Parser;
import com.epam.mathematics.impl.Result;

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
        Parser parser=new Parser();
        String []params={expression};
        return parser.run(params);
    }
}
