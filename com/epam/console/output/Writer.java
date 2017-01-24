package com.epam.console.output;

/**
 * Created by Женя on 23.01.2017.
 */
public class Writer implements Writable {
    @Override
    public void writeResult(String expression) {
        System.out.println("Your answer is: "+expression);
    }
    public void welcomeMessage() {
        System.out.println("Input your expression here or write 'Q' to exit.\n" +
                "You can use ',','/','*','%','-','+','(',')','^'.\n" +
                "Expression: ");
    }
}
