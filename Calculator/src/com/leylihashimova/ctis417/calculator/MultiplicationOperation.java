package com.leylihashimova.ctis417.calculator;

public class MultiplicationOperation extends Operation {
    protected MultiplicationOperation(double operand) {
        super(operand);
    }

    @Override
    public void calculate() {
        Calculator.getInstance().multiply(operand);
        Calculator.getInstance().setLastOperation(this);
    }

    @Override
    public void undo() throws CalculatorException {
        if(operand == 0) {
            throw new CalculatorException("Division cannot take 0 as operand.");
        }

        Calculator.getInstance().divide(operand);
        Calculator.getInstance().setLastOperation(null);
    }
}
