package com.leylihashimova.ctis417.calculator;

import com.leylihashimova.ctis417.calculator.io.ConsoleInputBroadcaster;
import com.leylihashimova.ctis417.calculator.io.ConsoleOutputter;
import com.leylihashimova.ctis417.calculator.io.OutputEventBus;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var consoleInputBroadcaster = new ConsoleInputBroadcaster();
        var consoleOutputter = new ConsoleOutputter();

        var outputEventBus = OutputEventBus.getInstance();
        var calculator = Calculator.getInstance();

        outputEventBus.addListener(consoleOutputter);
        consoleInputBroadcaster.registerObserver(calculator);

        consoleInputBroadcaster.begin();

        // These can be called later on in the lifecycle for cleanup:
        // outputEventBus.removeListener(consoleOutputter);
        // consoleInputBroadcaster.unregisterObserver(calculator);
    }
}
