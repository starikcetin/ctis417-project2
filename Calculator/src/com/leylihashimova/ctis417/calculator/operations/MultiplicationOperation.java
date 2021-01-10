package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class MultiplicationOperation extends Operation {
    private final double operand;

    protected MultiplicationOperation(double operand) {
        this.operand = operand;
    }

    @Override
    public void calculate() {
        Calculator.getInstance().multiply(operand);
        Calculator.getInstance().addToHistory(this);
    }

    @Override
    public void undo() throws CalculatorException {
        Calculator.getInstance().divide(operand);
    }
}
