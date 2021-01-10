package com.leylihashimova.ctis417.calculator;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.io.ConsoleInputBroadcaster;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var calculator = new Calculator();

        var consoleInputBroadcaster = new ConsoleInputBroadcaster();
        consoleInputBroadcaster.registerObserver(calculator);
        consoleInputBroadcaster.begin();

        // This can be called later on in the lifecycle for cleanup:
        // consoleInputBroadcaster.unregisterObserver(calculator);
    }
}
