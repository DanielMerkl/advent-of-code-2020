package day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DockingDataTest {

    @Test
    void partOne_test() {
        String testInput = """
                mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
                mem[8] = 11
                mem[7] = 101
                mem[8] = 0""";
        DockingData dockingData = new DockingData(testInput);

        long result = dockingData.partOne();

        assertEquals(165, result);
    }

    @Test
    void partOne() {
        DockingData dockingData = new DockingData(Input.input);

        long result = dockingData.partOne();

        assertEquals(11926135976176L, result);
    }

    @Test
    void partTwo_test() {
        String testInput = """
                mask = 000000000000000000000000000000X1001X
                mem[42] = 100
                mask = 00000000000000000000000000000000X0XX
                mem[26] = 1""";
        DockingData dockingData = new DockingData(testInput);

        long result = dockingData.partTwo();

        assertEquals(208, result);
    }

    @Test
    void partTwo() {
        DockingData dockingData = new DockingData(Input.input);

        long result = dockingData.partTwo();

        assertEquals(4330547254348L, result);
    }

}
