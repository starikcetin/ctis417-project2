package com.leylihashimova.ctis417.calculator.operations.factories;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.operations.Operation;
import com.leylihashimova.ctis417.calculator.operations.SubtractionPerformer;
import com.leylihashimova.ctis417.calculator.operations.SubtractionPerformerOperationAdapter;

public class SubtractionOperationFactory extends OperationFactory {
    @Override
    public Operation create(Calculator calculator, double operand) {
        var subtractionPerformer = new SubtractionPerformer();
        return new SubtractionPerformerOperationAdapter(subtractionPerformer, calculator, operand);
    }
}
