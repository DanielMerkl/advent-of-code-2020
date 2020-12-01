package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepairTest {

    @Test
    void getChecksumForTwoEntries_test() {
        ReportRepair reportRepair = new ReportRepair(testInput);

        int checksum = reportRepair.getChecksumForTwoEntries(2020);

        assertEquals(514579, checksum);
    }

    @Test
    void getChecksumForTwoEntries() {
        ReportRepair reportRepair = new ReportRepair(Input.input);

        int checksum = reportRepair.getChecksumForTwoEntries(2020);

        assertEquals(969024, checksum);
    }

    @Test
    void getChecksumForThreeEntries_test() {
        ReportRepair reportRepair = new ReportRepair(testInput);

        int checksum = reportRepair.getChecksumForThreeEntries(2020);

        assertEquals(241861950, checksum);
    }

    @Test
    void getChecksumForThreeEntries() {
        ReportRepair reportRepair = new ReportRepair(Input.input);

        int checksum = reportRepair.getChecksumForThreeEntries(2020);

        assertEquals(230057040, checksum);
    }

    private final String testInput = """
            1721
            979
            366
            299
            675
            1456""";
}
