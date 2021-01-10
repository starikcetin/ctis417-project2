package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.Operation;

public abstract class OperationFactory {
    public abstract Operation create(Calculator calculator, double operand);
}
