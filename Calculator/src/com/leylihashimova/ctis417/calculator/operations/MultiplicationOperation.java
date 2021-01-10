package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class MultiplicationOperation extends Operation {
    private final Calculator calculator;
    private final double operand;

    protected MultiplicationOperation(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void calculate() {
        calculator.multiply(operand);
    }

    @Override
    public void undo() throws CalculatorException {
        calculator.divide(operand);
    }
}
