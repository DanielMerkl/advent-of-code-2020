package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {

    @Test
    void test_1() {
        BoardingPass boardingPass = new BoardingPass("FBFBBFFRLR");

        int id = boardingPass.getId();
        int row = boardingPass.getRow();
        int column = boardingPass.getColumn();

        assertEquals(357, id);
        assertEquals(44, row);
        assertEquals(5, column);
    }

    @Test
    void test_2() {
        BoardingPass boardingPass = new BoardingPass("BFFFBBFRRR");

        int id = boardingPass.getId();
        int column = boardingPass.getColumn();
        int row = boardingPass.getRow();

        assertEquals(567, id);
        assertEquals(70, row);
        assertEquals(7, column);
    }

    @Test
    void test_3() {
        BoardingPass boardingPass = new BoardingPass("FFFBBBFRRR");

        int id = boardingPass.getId();
        int column = boardingPass.getColumn();
        int row = boardingPass.getRow();

        assertEquals(119, id);
        assertEquals(14, row);
        assertEquals(7, column);
    }

    @Test
    void test_4() {
        BoardingPass boardingPass = new BoardingPass("BBFFBBFRLL");

        int id = boardingPass.getId();
        int column = boardingPass.getColumn();
        int row = boardingPass.getRow();

        assertEquals(820, id);
        assertEquals(102, row);
        assertEquals(4, column);
    }

}
