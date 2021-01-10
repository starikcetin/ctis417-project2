package com.leylihashimova.ctis417.calculator.core;

import com.leylihashimova.ctis417.calculator.input.InputObserver;
import com.leylihashimova.ctis417.calculator.operations.Operation;
import com.leylihashimova.ctis417.calculator.operations.factories.OperationFactory;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Stack;

public class Calculator extends InputObserver {
    private final Stack<Operation> history = new Stack<>();
    private final NumberFormat doubleFormatter = new DecimalFormat("#0.00");
    private final Map<Operator, OperationFactory> operationFactoryMap;
    private double lastResult = 0;

    public Calculator(Map<Operator, OperationFactory> operationFactoryMap) {
        this.operationFactoryMap = operationFactoryMap;
    }

    public double getLastResult() {
        return lastResult;
    }

    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
    }

    public void addToHistory(Operation operation) {
        history.push(operation);
    }

    private void undoLastOperation() throws CalculatorException {
        var op = history.pop();
        op.undo();
    }

    public void add(double number) {
        lastResult += number;
    }

    public void subtract(double number) {
        lastResult -= number;
    }

    public void multiply(double number) {
        lastResult *= number;
    }

    public void divide(double number) throws CalculatorException {
        if (number == 0) {
            throw new CalculatorException("Division cannot take 0 as operand");
        }

        lastResult /= number;
    }

    private void output() {
        System.out.println("= " + doubleFormatter.format(lastResult));
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
            System.out.println("Error: " + e.getMessage());
        }

        output();
    }

    private void handleInput(String cleaned) throws CalculatorException {
        if (cleaned.equals("undo")) {
            if (history.empty()) {
                throw new CalculatorException("Nothing to undo");
            }

            undoLastOperation();
        } else {
            var expression = ExpressionParser.getInstance().parseInput(cleaned);
            var operation = createOperation(expression);
            operation.calculate();
            addToHistory(operation);
        }
    }

    private Operation createOperation(Expression expression) throws CalculatorException {
        var factory = operationFactoryMap.get(expression.operator);

        if (factory == null) {
            throw new CalculatorException("Operator not supported: " + expression.operator);
        }

        return factory.create(this, expression.operand);
    }
}
