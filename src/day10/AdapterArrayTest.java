package day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterArrayTest {

    @Test
    void getNumberOf1JoltDifference_test1() {
        AdapterArray adapterArray = new AdapterArray(firstTestInput);

        int result = adapterArray.getNumberOfAdaptersWithJoltageDelta(1);

        assertEquals(7, result);
    }

    @Test
    void getNumberOf1JoltDifference_test2() {
        AdapterArray adapterArray = new AdapterArray(secondTestInput);

        int result = adapterArray.getNumberOfAdaptersWithJoltageDelta(1);

        assertEquals(22, result);
    }

    @Test
    void getNumberOf3JoltDifference_test1() {
        AdapterArray adapterArray = new AdapterArray(firstTestInput);

        int result = adapterArray.getNumberOfAdaptersWithJoltageDelta(3);

        assertEquals(5, result);
    }

    @Test
    void getNumberOf3JoltDifference_test2() {
        AdapterArray adapterArray = new AdapterArray(secondTestInput);

        int result = adapterArray.getNumberOfAdaptersWithJoltageDelta(3);

        assertEquals(10, result);
    }

    @Test
    void partOne_test1() {
        AdapterArray adapterArray = new AdapterArray(firstTestInput);

        int result = adapterArray.partOne();

        assertEquals(35, result);
    }

    @Test
    void partOne_test2() {
        AdapterArray adapterArray = new AdapterArray(secondTestInput);

        int result = adapterArray.partOne();

        assertEquals(220, result);
    }

    @Test
    void partOne() {
        AdapterArray adapterArray = new AdapterArray(Input.input);

        int result = adapterArray.partOne();

        assertEquals(2263, result);
    }

    @Test
    void numberOfDistinctWaysToArrangeAdapters_test1() {
        AdapterArray adapterArray = new AdapterArray(firstTestInput);

        long result = adapterArray.numberOfDistinctWaysToArrangeAdapters();

        assertEquals(8, result);
    }

    @Test
    void numberOfDistinctWaysToArrangeAdapters_test2() {
        AdapterArray adapterArray = new AdapterArray(secondTestInput);

        long result = adapterArray.numberOfDistinctWaysToArrangeAdapters();

        assertEquals(19208, result);
    }

    @Test
    void numberOfDistinctWaysToArrangeAdapters() {
        AdapterArray adapterArray = new AdapterArray(Input.input);

        long result = adapterArray.numberOfDistinctWaysToArrangeAdapters();

        assertEquals(396857386627072L, result);
    }

    private final String firstTestInput = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4""";

    private final String secondTestInput = """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3""";
}
