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
        var rawTokens = input.split(" ");
        var sanitizedTokens = sanitizeTokens(rawTokens);

        return switch (sanitizedTokens.length) {
            case 0 -> throw new CalculatorException("Not enough tokens (" + sanitizedTokens.length + " tokens)");
            case 1 -> tokenizeNoSpace(sanitizedTokens[0]);
            case 2 -> sanitizedTokens;
            default -> throw new CalculatorException("Too many tokens (" + sanitizedTokens.length + " tokens)");
        };
    }

    private String[] tokenizeNoSpace(String word) throws CalculatorException {
        var trimmedWord = word.trim();

        if(trimmedWord.length() < 2) {
            throw new CalculatorException("Not enough tokens (" + trimmedWord.length() + " tokens)");
        }

        var firstChar = trimmedWord.substring(0, 1);
        var rest = trimmedWord.substring(1);

        return Arrays.asList(firstChar, rest).toArray(String[]::new);
    }

    private String[] sanitizeTokens(String[] tokens) {
        return Arrays.stream(tokens)
                .map(String::trim)
                .filter(t -> !t.isBlank())
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
            default -> throw new CalculatorException("Operator not supported (" + operator + ")");
        };
    }

    private double parseOperand(String operand) throws CalculatorException {
        try {
            return Double.parseDouble(operand);
        } catch (NumberFormatException e) {
            throw new CalculatorException("Malformed operand (" + operand + ")");
        }
    }
}
