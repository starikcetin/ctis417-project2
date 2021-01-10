package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class DivisionOperation extends Operation {
    private final double operand;

    protected DivisionOperation(double operand) {
        this.operand = operand;
    }

    @Override
    public void calculate() throws CalculatorException {
        Calculator.getInstance().divide(operand);
        Calculator.getInstance().addToHistory(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().multiply(operand);
    }
}
