package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;

public class AdditionOperation extends Operation {
    private final Calculator calculator;
    private final double operand;

    public AdditionOperation(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void calculate() {
        calculator.add(operand);
    }

    @Override
    public void undo() {
        calculator.subtract(operand);
    }
}
