package day08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandheldHalting {
    private final List<Instruction> initialInstructions;
    private List<Instruction> instructions;
    private int instructionPointer = 0;
    private int accumulator = 0;
    private final Set<Integer> visitedInstructions = new HashSet<>();
    private boolean programTerminatedCorrectly = false;

    public HandheldHalting(String input) {
        initialInstructions = input.lines()
                .map(Instruction::new)
                .collect(Collectors.toList());
        instructions = deepCloneInitialInstructions();
    }

    public int valueOfAccumulatorBeforeExecutingInstructionSecondTime() {
        while (hasNotVisitedTheSameInstructionTwice()) {
            processInstruction();
        }

        return accumulator;
    }

    private void processInstruction() {
        Instruction instruction = instructions.get(instructionPointer);

        visitedInstructions.add(instructionPointer);

        switch (instruction.getOperation()) {
            case Accumulate -> {
                accumulator += instruction.getArgument();
                instructionPointer++;
            }
            case Jump -> instructionPointer += instruction.getArgument();
            case None -> instructionPointer++;
        }

        if (instructionPointer == instructions.size()) {
            programTerminatedCorrectly = true;
        }

        instructionPointer = instructionPointer % instructions.size();
    }

    public int valueOfAccumulatorAfterProgramTerminates() {
        int modifyIndex = 0;

        while (!programTerminatedCorrectly) {
            resetProgram();
            modifyInstruction(modifyIndex);
            modifyIndex++;

            while (hasNotVisitedTheSameInstructionTwice()) {
                processInstruction();
            }
        }

        return accumulator;
    }

    private boolean hasNotVisitedTheSameInstructionTwice() {
        return !visitedInstructions.contains(instructionPointer);
    }

    private void resetProgram() {
        instructions = deepCloneInitialInstructions();
        accumulator = 0;
        instructionPointer = 0;
        visitedInstructions.clear();
    }

    private void modifyInstruction(int index) {
        Instruction instruction = instructions.get(index);

        switch (instruction.getOperation()) {
            case None -> instruction.setOperation(Operation.Jump);
            case Jump -> instruction.setOperation(Operation.None);
        }
    }

    private List<Instruction> deepCloneInitialInstructions() {
        return initialInstructions.stream()
                .map(Instruction::new)
                .collect(Collectors.toList());
    }
}
