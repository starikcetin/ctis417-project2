package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.DivisionOperation;
import com.leylihashimova.ctis417.calculator.operations.Operation;

public class DivisionOperationFactory extends OperationFactory {
    @Override
    public Operation create(Calculator calculator, double operand) {
        return new DivisionOperation(calculator, operand);
    }
}
