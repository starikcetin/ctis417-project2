package com.leylihashimova.ctis417.calculator;

import com.leylihashimova.ctis417.calculator.io.InputObserver;
import com.leylihashimova.ctis417.calculator.io.OutputEventBus;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator extends InputObserver {
    //En son gelen sonuc
    private double lastResult = 0;
    private Operation lastOperation = null;
    private NumberFormat doubleFormatter = new DecimalFormat("#0.00");

    private static Calculator instance;

    public synchronized static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }

        return instance;
    }

    private Calculator() {}

    public void setLastOperation(Operation lastOperation) {
        this.lastOperation = lastOperation;
    }

    public void add(double number) {
        lastResult += number;
        output();
    }

    public void subtract(double number) {
        lastResult -= number;
        output();
    }

    public void multiply(double number) {
        lastResult *= number;
        output();
    }

    public void divide(double number) {
        lastResult /= number;
        output();
    }

    private void output() {
        OutputEventBus.getInstance().emit(" = " + doubleFormatter.format(lastResult));
    }

    @Override
    public void updateInput(String input) {
        if(input == null) {
            return;
        }

        var cleaned = input.trim();

        if(cleaned.equals("")) {
            return;
        }

        try {
            processInput(cleaned);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processInput(String cleaned) throws CalculatorException {
        if(cleaned.equals("undo")) {
            if(lastOperation == null) {
                throw new CalculatorException("You need to perform an operation before undoing.");
            }

            lastOperation.undo();
        } else {
            var operation = Operation.create(cleaned);
            operation.calculate();
        }
    }
}
