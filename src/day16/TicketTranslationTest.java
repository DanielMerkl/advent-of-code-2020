package day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTranslationTest {

    @Test
    void getErrorRate_test() {
        String testInput = """
                class: 1-3 or 5-7
                row: 6-11 or 33-44
                seat: 13-40 or 45-50
                            
                your ticket:
                7,1,14
                            
                nearby tickets:
                7,3,47
                40,4,50
                55,2,20
                38,6,12""";
        TicketTranslation ticketTranslation = new TicketTranslation(testInput);

        long result = ticketTranslation.getErrorRate();

        assertEquals(71, result);
    }

    @Test
    void getErrorRate() {
        TicketTranslation ticketTranslation = new TicketTranslation(Input.input);

        long result = ticketTranslation.getErrorRate();

        assertEquals(20058, result);
    }

    @Test
    void partTwo() {
        TicketTranslation ticketTranslation = new TicketTranslation(Input.input);

        long result = ticketTranslation.partTwo();

        assertEquals(366871907221L, result);
    }

}
