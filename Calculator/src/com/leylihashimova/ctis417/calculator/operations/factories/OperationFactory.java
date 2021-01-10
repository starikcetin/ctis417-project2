package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.Operation;

public interface OperationFactory {
    Operation create(Calculator calculator, double operand);
}
