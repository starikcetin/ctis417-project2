package com.leylihashimova.ctis417.calculator.operations;

import com.leylihashimova.ctis417.calculator.core.CalculatorException;

public interface Operation {
    void calculate() throws CalculatorException;

    void undo() throws CalculatorException;
}
