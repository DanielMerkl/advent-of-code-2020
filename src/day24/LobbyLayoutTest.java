package day24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LobbyLayoutTest {

    @Test
    void partOne_test() {
        LobbyLayout lobbyLayout = LobbyLayout.from(testInput);

        long result = lobbyLayout.partOne();

        assertEquals(10, result);
    }

    @Test
    void partOne() {
        LobbyLayout lobbyLayout = LobbyLayout.from(Input.input);

        long result = lobbyLayout.partOne();

        assertEquals(339, result);
    }

    @ParameterizedTest
    @MethodSource("getNumberOfExecutions")
    void partTwo_test(int numberOfExecutions, int expected) {
        LobbyLayout lobbyLayout = LobbyLayout.from(testInput);

        long result = lobbyLayout.partTwo(numberOfExecutions);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> getNumberOfExecutions() {
        return Stream.of(
                Arguments.of(1, 15),
                Arguments.of(10, 37),
                Arguments.of(20, 132),
                Arguments.of(100, 2208)
        );
    }

    @Test
    void partTwo() {
        LobbyLayout lobbyLayout = LobbyLayout.from(Input.input);

        long result = lobbyLayout.partTwo(100);

        assertEquals(3794, result);
    }

    private final String testInput = """
            sesenwnenenewseeswwswswwnenewsewsw
            neeenesenwnwwswnenewnwwsewnenwseswesw
            seswneswswsenwwnwse
            nwnwneseeswswnenewneswwnewseswneseene
            swweswneswnenwsewnwneneseenw
            eesenwseswswnenwswnwnwsewwnwsene
            sewnenenenesenwsewnenwwwse
            wenwwweseeeweswwwnwwe
            wsweesenenewnwwnwsenewsenwwsesesenwne
            neeswseenwwswnwswswnw
            nenwswwsewswnenenewsenwsenwnesesenew
            enewnwewneswsewnwswenweswnenwsenwsw
            sweneswneswneneenwnewenewwneswswnese
            swwesenesewenwneswnwwneseswwne
            enesenwswwswneneswsenwnewswseenwsese
            wnwnesenesenenwwnenwsewesewsesesew
            nenewswnwewswnenesenwnesewesw
            eneswnwswnwsenenwnwnwwseeswneewsenese
            neswnwewnwnwseenwseesewsenwsweewe
            wseweeenwnesenwwwswnew""";

}
