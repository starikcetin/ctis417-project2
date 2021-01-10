package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.CalculatorException;
import com.leylihashimova.ctis417.calculator.core.Expression;

public abstract class Operation {
    public static Operation create(Expression expression) throws CalculatorException {
        switch (expression.operator) {
            case Add:
                return new AdditionOperation(expression.operand);

            case Subtract:
                var subtractionPerformer = new SubtractionPerformer();
                return new SubtractionPerformerOperationAdapter(subtractionPerformer, expression.operand);

            case Multiply:
                var operation = new MultiplicationOperation(expression.operand);

                return expression.operand == 0
                        ? new RestoreStateOnUndoOperationDecorator(operation, Calculator.getInstance().getLastResult())
                        : operation;

            case Divide:
                return new DivisionOperation(expression.operand);

            default:
                throw new CalculatorException("Operator not supported: " + expression.operator);
        }
    }

    public abstract void calculate() throws CalculatorException;

    public abstract void undo() throws CalculatorException;
}
