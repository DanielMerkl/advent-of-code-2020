package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryBoardingTest {

    @Test
    void highestSeatId() {
        BinaryBoarding binaryBoarding = new BinaryBoarding(Input.input);

        int seatId = binaryBoarding.getHighestSeatId();

        assertEquals(935, seatId);
    }

    @Test
    void idOfMySeat() {
        BinaryBoarding binaryBoarding = new BinaryBoarding(Input.input);

        int seatId = binaryBoarding.getIdOfMySeat();

        assertEquals(743, seatId);
    }

}
