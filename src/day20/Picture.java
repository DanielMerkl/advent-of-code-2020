package day20;

import java.util.Arrays;
import java.util.List;

public class Picture {
    public static final int TILE_SIZE = 8;
    public static final int NUMBER_OF_TILES = 12;
    private static final int PICTURE_SIZE = TILE_SIZE * NUMBER_OF_TILES;
    private char[][] picture = new char[PICTURE_SIZE][PICTURE_SIZE];
    private final String monster = """
                              # 
            #    ##    ##    ###
             #  #  #  #  #  #   """;

    public Picture(List<Tile> tiles) {
        Tile leftmostTileOfCurrentRow = tiles.stream()
                .filter(tile -> tile.getTop() == null && tile.getLeft() == null)
                .findAny()
                .orElseThrow();

        int row = 0;
        while (leftmostTileOfCurrentRow != null) {
            drawVertical(leftmostTileOfCurrentRow, row);
            leftmostTileOfCurrentRow = leftmostTileOfCurrentRow.getBottom();
            row += TILE_SIZE;
        }
    }

    private void drawVertical(Tile current, int row) {
        int column = 0;
        while (current != null) {
            drawTile(current, row, column);
            current = current.getRight();
            column += TILE_SIZE;
        }
    }

    private void drawTile(Tile tile, int row, int column) {
        char[][] croppedTileImage = tile.getCroppedImage();

        for (int r = 0; r < croppedTileImage.length; r++) {
            for (int c = 0; c < croppedTileImage[r].length; c++) {
                picture[row + r][column + c] = croppedTileImage[r][c];
            }
        }
    }

    public long getNumberOfHashtagsThatAreNotPartOfMonsters() {
        String[] monsterLines = monster.split("\n");

        boolean containsMonsters = false;

        for (int numberOfRotations = 0; numberOfRotations < 4; numberOfRotations++) {
            for (int row = 0; row < picture.length - monsterLines.length; row++) {
                for (int column = 0; column < picture[row].length - monsterLines[0].length(); column++) {
                    if (matchesMonsterPattern(row, column)) {
                        overwriteMatches(row, column);
                        containsMonsters = true;
                    }
                }
            }

            if (containsMonsters) {
                return numberOfHashtags();
            }
            rotatePicture();
        }

        flipPicture();

        for (int numberOfRotations = 0; numberOfRotations < 4; numberOfRotations++) {
            for (int row = 0; row < picture.length - monsterLines.length; row++) {
                for (int column = 0; column < picture[row].length - monsterLines[0].length(); column++) {
                    if (matchesMonsterPattern(row, column)) {
                        overwriteMatches(row, column);
                        containsMonsters = true;
                    }
                }
            }

            if (containsMonsters) {
                return numberOfHashtags();
            }
            rotatePicture();
        }

        return 0;
    }

    private long numberOfHashtags() {
        int numberOfHashtags = 0;

        for (char[] chars : picture) {
            for (char c : chars) {
                if (c == '#') {
                    numberOfHashtags++;
                }
            }
        }

        return numberOfHashtags;
    }

    private boolean matchesMonsterPattern(int row, int column) {
        String[] monsterLines = monster.split("\n");

        for (int r = 0; r < monsterLines.length; r++) {
            for (int c = 0; c < monsterLines[r].toCharArray().length; c++) {
                if (monsterLines[r].charAt(c) == '#' && picture[row + r][column + c] != '#') {
                    return false;
                }
            }
        }

        return true;
    }

    private void overwriteMatches(int row, int column) {
        String[] monsterLines = monster.split("\n");

        for (int r = 0; r < monsterLines.length; r++) {
            for (int c = 0; c < monsterLines[r].toCharArray().length; c++) {
                if (monsterLines[r].charAt(c) == '#') {
                    picture[row + r][column + c] = 'O';
                }
            }
        }
    }

    private void rotatePicture() {
        char[][] rotatedPicture = new char[PICTURE_SIZE][PICTURE_SIZE];

        for (int row = 0; row < picture.length; row++) {
            for (int column = 0; column < picture[row].length; column++) {
                rotatedPicture[column][picture.length - row - 1] = picture[row][column];
            }
        }

        picture = rotatedPicture;
    }

    private void flipPicture() {
        char[][] flippedPicture = new char[PICTURE_SIZE][PICTURE_SIZE];

        for (int row = 0; row < picture.length; row++) {
            flippedPicture[picture.length - row - 1] = picture[row];
        }

        picture = flippedPicture;
    }
}
