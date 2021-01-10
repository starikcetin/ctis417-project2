package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public class RestoreStateOnUndoOperationDecorator extends Operation {
    private final Operation operation;
    private final Calculator calculator;
    private final double resultBefore;

    protected RestoreStateOnUndoOperationDecorator(Operation operation, Calculator calculator) {
        this.operation = operation;
        this.calculator = calculator;
        this.resultBefore = calculator.getLastResult();
    }

    @Override
    public void calculate() throws CalculatorException {
        operation.calculate();
        calculator.ignoreLastOperationFromHistory();
        calculator.addToHistory(this);
    }

    @Override
    public void undo() {
        calculator.setLastResult(resultBefore);
    }
}
