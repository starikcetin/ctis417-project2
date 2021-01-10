package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class DivisionOperation extends Operation {
    private final Calculator calculator;
    private final double operand;

    protected DivisionOperation(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void calculate() throws CalculatorException {
        calculator.divide(operand);
    }

    @Override
    public void undo() {
        calculator.multiply(operand);
    }
}
