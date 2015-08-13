package com.goeuro;

import com.goeuro.Runner.MainRunner;
import com.goeuro.parser.Parser;

public class Main {
    static final String emptyEntry = "You didn't enter anything, try again!";

    public static void main(String[] args) {
        MainRunner mainRunner = new MainRunner();
        if (args.length == 0) {
            System.out.printf(emptyEntry);
            return;
        }

//        String userInput = "Berlin";

        String userInput = args[0];
        String result = mainRunner.processUserInput(userInput);
        System.out.println(result);
    }
}
