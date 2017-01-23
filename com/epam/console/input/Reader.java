package com.epam.console.input;

import java.util.Scanner;

/**
 * Created by Женя on 23.01.2017.
 */
public class Reader implements Readable {
    @Override
     public String read() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        return expression;
    }
}
