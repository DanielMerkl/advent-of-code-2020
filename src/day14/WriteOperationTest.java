package day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WriteOperationTest {

    @Test
    void initializesCorrectly() {
        WriteOperation writeOperation = new WriteOperation("mem[7] = 101");

        assertEquals(7, writeOperation.getMemoryAddress());
        assertEquals(101, writeOperation.getValue());
    }

}
