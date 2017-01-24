package com.epam.mathematics.impl;

import com.epam.mathematics.Operation;

import java.util.LinkedList;

/**
 * Created by Женя on 24.01.2017.
 */
public class Parser implements Operation<Double, String> {
    @Override
    public Double run(String[] args) {
        LinkedList<Double> st = new LinkedList<>(); // сюда наваливают цифры
        LinkedList<String> op = new LinkedList<>(); // сюда опрераторы и st и op в порядке поступления
        Result result = new Result();
        Priority priority = new Priority();
        for (int i = 0; i < args[0].length(); i++) { // парсим строку с выражением и вычисляем
            char c = args[0].charAt(i);
            if (c == '(')
                op.add("(");
            else if (c == ')') {
                while (op.getLast() != "(") {

                }
                op.removeLast();

            } else if (isOperator(c)) {
                Character[] parametrs = {c};
                Character[] secondParametrs = {c};
                while (!op.isEmpty() && priority.run(parametrs) >= priority.run(secondParametrs)) {
                    String[] params = {(st.get(st.size() - 1)).toString(), (st.get(st.size() - 2)).toString(), op.removeLast()};

                    st.removeLast();
                    st.removeLast();
                    st.add(result.run(params));
                }
                op.add(secondParametrs[0].toString());
            } else {
                String operand = "";
                while (i < args[0].length() && Character.isDigit(args[0].charAt(i)))
                    operand += args[0].charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty()) {
            String[] params = {(st.get(st.size() - 1)).toString(), (st.get(st.size() - 2)).toString(), op.removeLast()};
            st.removeLast();
            st.removeLast();
            st.add(result.run(params));
        }
        return st.get(0);  // возврат результата
    }


    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }
}