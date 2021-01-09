package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

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
                var subtractionPerformer = new SubtractionPerformer();
                return new SubtractionPerformerOperationAdapter(subtractionPerformer, operand);
            case "*":
                var operation = new MultiplicationOperation(operand);

                if(operand == 0) {
                    return new RestoreStateOnUndoOperationDecorator(operand, operation, Calculator.getInstance().getLastResult());
                } else {
                    return operation;
                }
            case "/":
                return new DivisionOperation(operand);
        }

        throw new CalculatorException("Operator not recognized: " + operator);
    }

    public abstract void calculate() throws CalculatorException;
    public abstract void undo() throws CalculatorException;
}
