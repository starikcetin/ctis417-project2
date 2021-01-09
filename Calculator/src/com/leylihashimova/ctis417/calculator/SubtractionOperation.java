package com.leylihashimova.ctis417.calculator;

public class SubtractionOperation extends Operation {
    protected SubtractionOperation(double operand) {
        super(operand);
    }

    @Override
    public void calculate() {
        Calculator.getInstance().subtract(operand);
        Calculator.getInstance().setLastOperation(this);
    }


    @Override
    public void undo() {
        Calculator.getInstance().add(operand);
        Calculator.getInstance().setLastOperation(null);
    }
}

