package com.leylihashimova.ctis417.calculator;

import com.leylihashimova.ctis417.calculator.core.Calculator;
import com.leylihashimova.ctis417.calculator.core.Operator;
import com.leylihashimova.ctis417.calculator.input.ConsoleInputBroadcaster;
import com.leylihashimova.ctis417.calculator.operations.factories.AdditionOperationFactory;
import com.leylihashimova.ctis417.calculator.operations.factories.DivisionOperationFactory;
import com.leylihashimova.ctis417.calculator.operations.factories.MultiplicationOperationFactory;
import com.leylihashimova.ctis417.calculator.operations.factories.SubtractionOperationFactory;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        var operationFactoryMap = Map.of(
                Operator.Add, new AdditionOperationFactory(),
                Operator.Subtract, new SubtractionOperationFactory(),
                Operator.Divide, new DivisionOperationFactory(),
                Operator.Multiply, new MultiplicationOperationFactory()
        );

        var calculator = new Calculator(operationFactoryMap);

        var consoleInputBroadcaster = new ConsoleInputBroadcaster();
        consoleInputBroadcaster.registerObserver(calculator);


        System.out.println("Simple Calculator");
        System.out.println("Possible commands:");
        System.out.println("1. undo");
        System.out.println("2. operator operand");
        System.out.println("Expression examples: +2   |   - 5.4   |   * 45.67   |   /5");
        System.out.println();


        consoleInputBroadcaster.begin();

        // This can be called later on in the lifecycle for cleanup:
        // consoleInputBroadcaster.unregisterObserver(calculator);
    }
}
