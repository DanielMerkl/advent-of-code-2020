package day18;

import java.util.Arrays;
import java.util.Stack;

public class Expression {
    private String expressionString;

    public Expression(String expressionString) {
        this.expressionString = expressionString.replace(" ", "");
    }

    public long evaluate() {
        Stack<Operator> operators = new Stack<>();
        Stack<Long> values = new Stack<>();

        for (char c : expressionString.toCharArray()) {
            switch (c) {
                case '+' -> operators.push(Operator.ADDITION);
                case '*' -> operators.push(Operator.MULTIPLICATION);
                case '(' -> operators.push(Operator.PARENTHESIS_OPEN);
                case ')' -> {
                    if (operators.size() < 2) continue;

                    operators.pop(); // remove opening parenthesis
                    Operator operator = operators.pop();
                    switch (operator) {
                        case ADDITION -> {
                            long a = values.pop();
                            long b = values.pop();
                            values.push(a + b);
                        }
                        case MULTIPLICATION -> {
                            long a = values.pop();
                            long b = values.pop();
                            values.push(a * b);
                        }
                        case PARENTHESIS_OPEN -> operators.push(operator);
                    }
                }
                default -> {
                    long value = Long.parseLong(String.valueOf(c));
                    values.push(value);
                    if (values.size() < 2) continue;

                    Operator operator = operators.pop();
                    if (operator.equals(Operator.PARENTHESIS_OPEN) || operator.equals(Operator.PARENTHESIS_CLOSE)) {
                        operators.push(operator);
                        continue;
                    }
                    switch (operator) {
                        case ADDITION -> {
                            long a = values.pop();
                            long b = values.pop();
                            values.push(a + b);
                        }
                        case MULTIPLICATION -> {
                            long a = values.pop();
                            long b = values.pop();
                            values.push(a * b);

                        }
                    }
                }
            }
        }

        return values.pop();
    }

    public long evaluateWithPrecedence() {
        while (expressionString.contains("(") || expressionString.contains(")")) {
            evaluateAndReplaceSubExpressionInsideRightmostParenthesis();
        }

        if (expressionString.contains("*")) {
            String[] expressionsWithAdditionsExclusively = expressionString.split("\\*");
            return Arrays.stream(expressionsWithAdditionsExclusively)
                    .map(Expression::new)
                    .map(Expression::evaluateWithPrecedence)
                    .reduce(1L, (a, b) -> a * b);
        }

        return Arrays.stream(expressionString.split("\\+"))
                .mapToLong(Long::parseLong)
                .sum();
    }

    private void evaluateAndReplaceSubExpressionInsideRightmostParenthesis() {
        String subExpressionString = getRightmostSubExpressionString();
        Expression subExpression = new Expression(subExpressionString);
        String resultOfSubExpression = String.valueOf(subExpression.evaluateWithPrecedence());
        String subExpressionWithParenthesis = "(" + subExpressionString + ")";
        expressionString = expressionString.replace(subExpressionWithParenthesis, resultOfSubExpression);
    }

    private String getRightmostSubExpressionString() {
        int start = expressionString.lastIndexOf('(');
        String expressionStringFromLastOpeningParenthesis = expressionString.substring(start);
        int end = expressionStringFromLastOpeningParenthesis.indexOf(')');
        return expressionString.substring(start + 1, start + end);
    }
}
