package com.leylihashimova.ctis417.calculator;

import java.util.Arrays;

public abstract class Operation {
    protected final double operand;

    protected Operation(double operand) {
        this.operand = operand;
    }

    public static Operation create(String statement) throws CalculatorException {
        // TODO: get singleton instance of Calculator here and pass it via constructor to instances of Operaiton

        String[] tokensRaw = statement.split(" ");
        String[] tokens = Arrays.stream(tokensRaw).filter(t -> t != null && !t.equals("")).toArray(String[]::new);

        if(tokens.length < 2) {
            throw new CalculatorException("Not enough tokens, make sure you put at least one space in between operator and operand.");
        }

        String operator = tokens[0];
        String operandRaw = tokens[1];
        double operand = Double.parseDouble(operandRaw);

        switch (operator) {
            case "+":
                return new AdditionOperation(operand);
            case "-":
                return new SubtractionOperation(operand);
            case "*":
                return new MultiplicationOperation(operand);
            case "/":
                return new DivisionOperation(operand);
        }

        throw new CalculatorException("Operator not recognized: " + operator);
    }

    public abstract void calculate() throws CalculatorException;
    public abstract void undo() throws CalculatorException;
}
