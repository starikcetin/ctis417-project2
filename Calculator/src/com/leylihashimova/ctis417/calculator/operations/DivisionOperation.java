package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class DivisionOperation extends Operation {
    protected DivisionOperation(double operand) {
        super(operand);
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
