package com.leylihashimova.ctis417.calculator;

public class AdditionOperation extends Operation {
    protected AdditionOperation(double operand) {
        super(operand);
    }

    @Override
    public void calculate() {
        Calculator.getInstance().add(operand);
        Calculator.getInstance().setLastOperation(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().subtract(operand);
        Calculator.getInstance().setLastOperation(null);
    }
}
