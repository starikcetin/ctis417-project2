package com.leylihashimova.ctis417.calculator.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputBroadcaster extends InputSubject {
    public void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        System.out.print("> ");

        while ((input = br.readLine()) != null) {
            notifyObservers(input);
            System.out.print("> ");
        }
    }
}
