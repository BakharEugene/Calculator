package com.epam.mathematics.impl;

import com.epam.mathematics.Operation;
import com.sun.javafx.image.IntPixelGetter;

import java.util.LinkedList;

/**
 * Created by Женя on 24.01.2017.
 */
public class Parser implements Operation<Double, String> {
    @Override
    public Double run(String[] args) {
        String s=" "+args[0];
        LinkedList<Double> st = new LinkedList<Double>();
        LinkedList<Character> op = new LinkedList<Character>();
        Priority priority = new Priority();
        Result result = new Result();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(') {
                    String[] params = {st.removeLast().toString(), st.removeLast().toString(), op.removeLast().toString()};
                    st.add(result.run(params));
                }
                op.removeLast();
            } else if (isOperator(c)) {
                if (!op.isEmpty()) {
                    Character[] firstParam = {op.getLast()};
                    Character[] secondParam = {c};
                    while (!op.isEmpty() && priority.run(firstParam) >= priority.run(secondParam)) {
                        String[] params = {st.removeLast().toString(), st.removeLast().toString(), op.removeLast().toString()};
                        st.add(result.run(params));
                    }
                }
                if(c=='-'&&!Character.isDigit(s.charAt(i-1))&&s.charAt(i-1)!=')'){
                    String operand = "-";
                    i++;
                    while (i < s.length() &&(Character.isDigit(s.charAt(i))||s.charAt(i)=='.'))
                        operand += s.charAt(i++);
                    --i;
                    st.add(Double.parseDouble(operand));
                    continue;
                }
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && (Character.isDigit(s.charAt(i))||s.charAt(i)=='.'))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty()) {
            String[] params = {st.removeLast().toString(), st.removeLast().toString(), op.removeLast().toString()};
            st.add(result.run(params));
        }
        return st.get(0);
    }

    static boolean isDelim(char c) {
        return c == ' ';
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }
}