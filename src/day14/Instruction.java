package day14;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    private final String mask;
    private final List<WriteOperation> writeOperations = new ArrayList<>();

    public Instruction(String mask) {
        this.mask = mask;
    }

    public void addWriteOperation(WriteOperation writeOperation) {
        writeOperations.add(writeOperation);
    }

    public String getMask() {
        return mask;
    }

    public List<WriteOperation> getWriteOperations() {
        return writeOperations;
    }
}
