package com.leylihashimova.ctis417.calculator.io;

public class ConsoleOutputter implements IOutputEventListener {
    @Override
    public void onOutput(String output) {
        System.out.println(output);
    }
}
