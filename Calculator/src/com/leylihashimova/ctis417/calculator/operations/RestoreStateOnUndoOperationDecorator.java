package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class RestoreStateOnUndoOperationDecorator extends Operation {
    private final Operation operation;
    private final double resultBefore;

    protected RestoreStateOnUndoOperationDecorator(Operation operation, double resultBefore) {
        this.operation = operation;
        this.resultBefore = resultBefore;
    }

    @Override
    public void calculate() throws CalculatorException {
        operation.calculate();
        Calculator.getInstance().ignoreLastOperationFromHistory();
        Calculator.getInstance().addToHistory(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().setLastResult(resultBefore);
    }
}
