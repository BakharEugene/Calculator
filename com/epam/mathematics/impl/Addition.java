package com.epam.mathematics.impl;

import com.epam.mathematics.Operation;

/**
 * Created by Женя on 23.01.2017.
 */
public class Addition implements Operation {
    @Override
    public Double compute(Double a, Double b) {
        return a+b;
    }
}
