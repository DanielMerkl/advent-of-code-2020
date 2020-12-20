package day20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JurassicJigsawTest {

    @Test
    void partOne_test() {
        JurassicJigsaw jurassicJigsaw = new JurassicJigsaw(testInput);

        long result = jurassicJigsaw.partOne();

        assertEquals(20899048083289L, result);
    }

    @Test
    void partOne() {
        JurassicJigsaw jurassicJigsaw = new JurassicJigsaw(Input.input);

        long result = jurassicJigsaw.partOne();

        assertEquals(20033377297069L, result);
    }

    @Test
    void partTwo_test() {
        JurassicJigsaw jurassicJigsaw = new JurassicJigsaw(testInput);

        long result = jurassicJigsaw.partTwo();

        assertEquals(273, result);
    }

    @Test
    void partTwo() {
        JurassicJigsaw jurassicJigsaw = new JurassicJigsaw(Input.input);

        long result = jurassicJigsaw.partTwo();

        assertEquals(2084, result);
    }

    private final String testInput = """
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
            ..###..###
                        
            Tile 1951:
            #.##...##.
            #.####...#
            .....#..##
            #...######
            .##.#....#
            .###.#####
            ###.##.##.
            .###....#.
            ..#.#..#.#
            #...##.#..
                        
            Tile 1171:
            ####...##.
            #..##.#..#
            ##.#..#.#.
            .###.####.
            ..###.####
            .##....##.
            .#...####.
            #.##.####.
            ####..#...
            .....##...
                        
            Tile 1427:
            ###.##.#..
            .#..#.##..
            .#.##.#..#
            #.#.#.##.#
            ....#...##
            ...##..##.
            ...#.#####
            .#.####.#.
            ..#..###.#
            ..##.#..#.
                        
            Tile 1489:
            ##.#.#....
            ..##...#..
            .##..##...
            ..#...#...
            #####...#.
            #..#.#.#.#
            ...#.#.#..
            ##.#...##.
            ..##.##.##
            ###.##.#..
                        
            Tile 2473:
            #....####.
            #..#.##...
            #.##..#...
            ######.#.#
            .#...#.#.#
            .#########
            .###.#..#.
            ########.#
            ##...##.#.
            ..###.#.#.
                        
            Tile 2971:
            ..#.#....#
            #...###...
            #.#.###...
            ##.##..#..
            .#####..##
            .#..####.#
            #..#.#..#.
            ..####.###
            ..#.#.###.
            ...#.#.#.#
                        
            Tile 2729:
            ...#.#.#.#
            ####.#....
            ..#.#.....
            ....#..#.#
            .##..##.#.
            .#.####...
            ####.#.#..
            ##.####...
            ##..#.##..
            #.##...##.
                        
            Tile 3079:
            #.#.#####.
            .#..######
            ..#.......
            ######....
            ####.#..#.
            .#...#.##.
            #.#####.##
            ..#.###...
            ..#.......
            ..#.###...""";

}
