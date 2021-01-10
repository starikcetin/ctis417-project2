package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.MultiplicationOperation;
import com.leylihashimova.ctis417.calculator.operations.Operation;
import com.leylihashimova.ctis417.calculator.operations.RestoreStateOnUndoOperationDecorator;

public class MultiplicationOperationFactory extends OperationFactory {
    @Override
    public Operation create(Calculator calculator, double operand) {
        var operation = new MultiplicationOperation(calculator, operand);

        return operand == 0
                ? new RestoreStateOnUndoOperationDecorator(operation, calculator)
                : operation;
    }
}
