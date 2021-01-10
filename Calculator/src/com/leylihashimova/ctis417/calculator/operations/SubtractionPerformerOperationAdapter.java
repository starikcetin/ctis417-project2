package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;

public class SubtractionPerformerOperationAdapter extends Operation {
    private final SubtractionPerformer subtractionPerformer;
    private final Calculator calculator;
    private final double operand;

    public SubtractionPerformerOperationAdapter(SubtractionPerformer subtractionPerformer, Calculator calculator, double operand) {
        this.subtractionPerformer = subtractionPerformer;
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void calculate() {
        var left = calculator.getLastResult();
        var result = subtractionPerformer.perform(left, operand);
        calculator.setLastResult(result);
    }

    @Override
    public void undo() {
        var left = calculator.getLastResult();
        var result = subtractionPerformer.performInverse(left, operand);
        calculator.setLastResult(result);
    }
}
