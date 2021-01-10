package com.leylihashimova.ctis417.calculator.core;

import com.leylihashimova.ctis417.calculator.io.InputObserver;
import com.leylihashimova.ctis417.calculator.operations.Operation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;

public class Calculator extends InputObserver {
    private static Calculator instance;
    private final Stack<Operation> history = new Stack<>();
    private final NumberFormat doubleFormatter = new DecimalFormat("#0.00");
    private double lastResult = 0;

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
        var cleaned = input.trim();

        // Ignore empty input.
        if (cleaned.equals("")) {
            return;
        }

        try {
            handleInput(cleaned);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleInput(String cleaned) throws CalculatorException {
        if (cleaned.equals("undo")) {
            if (history.empty()) {
                throw new CalculatorException("You need to perform an operation before undoing.");
            }

            undoLastOperation();
        } else {
            var expression = ExpressionParser.getInstance().parseInput(cleaned);
            var operation = Operation.create(expression, this);
            operation.calculate();
        }
    }
}
