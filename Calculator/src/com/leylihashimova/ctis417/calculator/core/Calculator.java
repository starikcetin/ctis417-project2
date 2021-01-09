package com.leylihashimova.ctis417.calculator.core;

import com.leylihashimova.ctis417.calculator.io.InputObserver;
import com.leylihashimova.ctis417.calculator.operations.Operation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;

public class Calculator extends InputObserver {
    private static Calculator instance;
    private double lastResult = 0;
    private final Stack<Operation> history = new Stack<>();
    private final NumberFormat doubleFormatter = new DecimalFormat("#0.00");

    private Calculator() {
    }

    public synchronized static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }

        return instance;
    }

    public double getLastResult() {
        return lastResult;
    }

    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
        output();
    }

    public void addToHistory(Operation operation) {
        history.push(operation);
    }

    private void undoLastOperation() throws CalculatorException {
        var op = history.pop();
        op.undo();
    }

    public void ignoreLastOperationFromHistory() {
        history.pop();
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

    public void divide(double number) throws CalculatorException {
        if (number == 0) {
            throw new CalculatorException("Division cannot take 0 as operand.");
        }

        lastResult /= number;
        output();
    }

    private void output() {
        System.out.println(" = " + doubleFormatter.format(lastResult));
    }

    @Override
    public void updateInput(String input) {
        if (input == null) {
            return;
        }

        var cleaned = input.trim();

        if (cleaned.equals("")) {
            return;
        }

        try {
            processInput(cleaned);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processInput(String cleaned) throws CalculatorException {
        if (cleaned.equals("undo")) {
            if (history.empty()) {
                throw new CalculatorException("You need to perform an operation before undoing.");
            }

            undoLastOperation();
        } else {
            var operation = Operation.create(cleaned);
            operation.calculate();
        }
    }
}
