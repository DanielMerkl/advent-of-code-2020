package day18;

import java.util.List;
import java.util.stream.Collectors;

public class OperationOrder {
    List<Expression> expressions;

    public OperationOrder(String input) {
        expressions = input.lines()
                .map(Expression::new)
                .collect(Collectors.toList());
    }

    public long partOne() {
        return expressions.stream()
                .mapToLong(Expression::evaluate)
                .sum();
    }

    public long partTwo() {
        return expressions.stream()
                .mapToLong(Expression::evaluateWithPrecedence)
                .sum();
    }
}
