package day20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void initializesCorrectly() {
        String testInput = """
                Tile 2311:
                ..##.#..#.
                ##..#.....
                #...##..#.
                ####.#...#
                ##.##.###.
                ##...#.###
                .#.#.#..##
                ..#....#..
                ###...#.#.
                ..###..###""";
        Tile tile = new Tile(testInput);

        assertEquals(2311, tile.getId());
        assertEquals("..##.#..#.", tile.getTopBorder());
        assertEquals("...#.##..#", tile.getRightBorder());
        assertEquals("..###..###", tile.getBottomBorder());
        assertEquals(".#####..#.", tile.getLeftBorder());
    }

    @Test
    void rotates() {
        String testInput = """
                Tile 2311:
                ..##.#..#.
                ##..#.....
                #...##..#.
                ####.#...#
                ##.##.###.
                ##...#.###
                .#.#.#..##
                ..#....#..
                ###...#.#.
                ..###..###""";
        Tile tile = new Tile(testInput);

        tile.rotate();

        assertEquals("..##.#..#.", tile.getRightBorder());
        assertEquals("#..##.#...", tile.getBottomBorder());
        assertEquals("..###..###", tile.getLeftBorder());
        assertEquals(".#..#####.", tile.getTopBorder());
    }

    @Test
    void flips() {
        String testInput = """
                Tile 2311:
                ..##.#..#.
                ##..#.....
                #...##..#.
                ####.#...#
                ##.##.###.
                ##...#.###
                .#.#.#..##
                ..#....#..
                ###...#.#.
                ..###..###""";
        Tile tile = new Tile(testInput);

        tile.flip();

        assertEquals("..##.#..#.", tile.getBottomBorder());
        assertEquals("#..##.#...", tile.getRightBorder());
        assertEquals("..###..###", tile.getTopBorder());
        assertEquals(".#..#####.", tile.getLeftBorder());
    }

}
