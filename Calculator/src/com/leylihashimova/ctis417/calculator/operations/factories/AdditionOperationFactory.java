package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.AdditionOperation;
import com.leylihashimova.ctis417.calculator.operations.Operation;

public class AdditionOperationFactory extends OperationFactory {
    @Override
    public Operation create(Calculator calculator, double operand) {
        return new AdditionOperation(calculator, operand);
    }
}

