package com.leylihashimova.ctis417.calculator;

public class DivisionOperation extends Operation {
    protected DivisionOperation(double operand) {
        super(operand);
    }

    @Override
    public void calculate() throws CalculatorException {
        if(operand == 0) {
            throw new CalculatorException("Division cannot take 0 as operand.");
        }

        Calculator.getInstance().divide(operand);
        Calculator.getInstance().setLastOperation(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().multiply(operand);
        Calculator.getInstance().setLastOperation(null);
    }
}

