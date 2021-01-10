package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;

public class AdditionOperation extends Operation {
    private final double operand;

    protected AdditionOperation(double operand) {
        this.operand = operand;
    }

    @Override
    public void calculate() {
        Calculator.getInstance().add(operand);
        Calculator.getInstance().addToHistory(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().subtract(operand);
    }
}
