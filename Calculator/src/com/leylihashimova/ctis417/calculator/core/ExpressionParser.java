package com.leylihashimova.ctis417.calculator.core;

import java.util.Arrays;

public class ExpressionParser {
    private static ExpressionParser instance;

    private ExpressionParser() {
    }

    public static synchronized ExpressionParser getInstance() {
        if (instance == null) {
            instance = new ExpressionParser();
        }

        return instance;
    }

    public Expression parseInput(String input) throws CalculatorException {
        var tokens = tokenizeInput(input);
        return parseTokens(tokens);
    }

    private String[] tokenizeInput(String input) throws CalculatorException {
        String[] rawTokens = input.split("");
        String[] sanitizedTokens = sanitizeTokens(rawTokens);

        if (sanitizedTokens.length < 2) {
            throw new CalculatorException("Not enough tokens.");
        }

        if (sanitizedTokens.length > 2) {
            throw new CalculatorException("Too many tokens.");
        }

        return sanitizedTokens;
    }

    private String[] sanitizeTokens(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(t -> t != null && !t.equals("") && !t.equals(" "))
                .toArray(String[]::new);
    }

    private Expression parseTokens(String[] tokens) throws CalculatorException {
        var rawOperator = tokens[0];
        var rawOperand = tokens[1];

        var parsedOperator = parseOperator(rawOperator);
        var parsedOperand = parseOperand(rawOperand);

        return new Expression(parsedOperator, parsedOperand);
    }

    private Operator parseOperator(String operator) throws CalculatorException {
        return switch (operator) {
            case "+" -> Operator.Add;
            case "-" -> Operator.Subtract;
            case "*" -> Operator.Multiply;
            case "/" -> Operator.Divide;
            default -> throw new CalculatorException("Operator not supported.");
        };
    }

    private double parseOperand(String operand) throws CalculatorException {
        try {
            return Double.parseDouble(operand);
        } catch (Exception e) {
            throw new CalculatorException("Malformed operand. (" + e.getMessage() + ")");
        }
    }
}
