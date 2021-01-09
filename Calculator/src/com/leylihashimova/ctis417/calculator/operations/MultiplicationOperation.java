package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class MultiplicationOperation extends Operation {
    protected MultiplicationOperation(double operand) {
        super(operand);
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
