package com.leylihashimova.ctis417.calculator.core;

public class Expression {
    public final Operator operator;
    public final double operand;

    public Expression(Operator operator, double operand) {
        this.operator = operator;
        this.operand = operand;
    }
}
