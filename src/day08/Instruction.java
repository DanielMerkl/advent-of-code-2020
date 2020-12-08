package day08;

public class Instruction {
    private Operation operation;
    private final int argument;

    public Instruction(String input) {
        String[] split = input.split(" ");
        argument = Integer.parseInt(split[1]);

        String operationString = split[0];
        operation = switch (operationString) {
            case "acc" -> Operation.Accumulate;
            case "jmp" -> Operation.Jump;
            case "nop" -> Operation.None;
            default -> throw new InvalidOperationException(operationString);
        };
    }

    public Instruction(Instruction instruction) {
        operation = instruction.operation;
        argument = instruction.argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getArgument() {
        return argument;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
