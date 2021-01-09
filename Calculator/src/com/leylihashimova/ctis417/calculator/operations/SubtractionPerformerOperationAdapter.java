package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class SubtractionPerformerOperationAdapter extends Operation {
    private final SubtractionPerformer subtractionPerformer;

    protected SubtractionPerformerOperationAdapter(SubtractionPerformer subtractionPerformer, double operand) {
        super(operand);
        this.subtractionPerformer = subtractionPerformer;
    }

    @Override
    public void calculate() throws CalculatorException {
        var left = Calculator.getInstance().getLastResult();
        var result = subtractionPerformer.perform(left, operand);
        Calculator.getInstance().setLastResult(result);
        Calculator.getInstance().addToHistory(this);
    }

    @Override
    public void undo() throws CalculatorException {
        var left = Calculator.getInstance().getLastResult();
        var result = subtractionPerformer.performInverse(left, operand);
        Calculator.getInstance().setLastResult(result);
    }
}
