package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.MultiplicationOperation;
import com.leylihashimova.ctis417.calculator.operations.Operation;
import com.leylihashimova.ctis417.calculator.operations.OperationRestoreStateOnUndoDecorator;

public class MultiplicationOperationFactory implements OperationFactory {
    @Override
    public Operation create(Calculator calculator, double operand) {
        var operation = new MultiplicationOperation(calculator, operand);

        return operand == 0
                ? new OperationRestoreStateOnUndoDecorator(operation, calculator)
                : operation;
    }
}
