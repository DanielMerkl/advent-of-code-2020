package day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatingSystemTest {

    @Test
    void numberOfOccupiedSeats_test() {
        SeatingSystem seatingSystem = new SeatingSystem(testInput);

        int result = seatingSystem.numberOfOccupiedSeats(4,true);

        assertEquals(37, result);
    }

    @Test
    void numberOfOccupiedSeats() {
        SeatingSystem seatingSystem = new SeatingSystem(Input.input);

        int result = seatingSystem.numberOfOccupiedSeats(4,true);

        assertEquals(2427, result);
    }

    @Test
    void numberOfOccupiedSeatsInSight_test() {
        SeatingSystem seatingSystem = new SeatingSystem(testInput);

        int result = seatingSystem.numberOfOccupiedSeats(5,false);

        assertEquals(26, result);
    }

    @Test
    void numberOfOccupiedSeatsInSight() {
        SeatingSystem seatingSystem = new SeatingSystem(Input.input);

        int result = seatingSystem.numberOfOccupiedSeats(5,false);

        assertEquals(2199, result);
    }

    private final String testInput = """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL""";
}
