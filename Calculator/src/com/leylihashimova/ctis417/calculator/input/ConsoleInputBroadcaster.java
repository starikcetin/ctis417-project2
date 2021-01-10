package com.leylihashimova.ctis417.calculator.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleInputBroadcaster extends InputSubject {
    public void begin() {
        var br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("> ");

        br.lines().forEach(input -> {
            notifyObservers(input);
            System.out.print("> ");
        });
    }
}
