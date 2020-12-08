package day08;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String operationString) {
        super("Invalid operation '%s'".formatted(operationString));
    }
}
