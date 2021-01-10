package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public abstract class Operation {
    public abstract void calculate() throws CalculatorException;

    public abstract void undo() throws CalculatorException;
}
