package day20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JurassicJigsaw {
    private final List<Tile> tiles;

    public JurassicJigsaw(String input) {
        tiles = Arrays.stream(input.split("\n\n"))
                .map(Tile::new)
                .collect(Collectors.toList());

        connectTiles();
    }

    private void connectTiles() {
        Tile firstTile = tiles.get(0);
        firstTile.lock();
        List<Tile> lockedTiles = List.of(firstTile);

        while (lockedTiles.size() != tiles.size()) {
            for (Tile lockedTile : lockedTiles) {
                for (Tile possiblyAdjacentTile : tiles) {
                    if (possiblyAdjacentTile.equals(lockedTile)) continue;

                    findAndSaveMatch(lockedTile, possiblyAdjacentTile);
                    possiblyAdjacentTile.flip();
                    findAndSaveMatch(lockedTile, possiblyAdjacentTile);
                }
            }

            lockedTiles = tiles.stream()
                    .filter(Tile::isLocked)
                    .collect(Collectors.toList());
        }
    }

    private void findAndSaveMatch(Tile tile, Tile adjacentTile) {
        for (int numberOfRotations = 0; numberOfRotations < 4; numberOfRotations++) {
            String topBorder = tile.getTopBorder();
            String rightBorder = tile.getRightBorder();
            String bottomBorder = tile.getBottomBorder();
            String leftBorder = tile.getLeftBorder();

            if (topBorder.equals(adjacentTile.getBottomBorder())) {
                tile.setTop(adjacentTile);
                adjacentTile.setBottom(tile);
                adjacentTile.lock();
            }
            if (rightBorder.equals(adjacentTile.getLeftBorder())) {
                tile.setRight(adjacentTile);
                adjacentTile.setLeft(tile);
                adjacentTile.lock();
            }
            if (bottomBorder.equals(adjacentTile.getTopBorder())) {
                tile.setBottom(adjacentTile);
                adjacentTile.setTop(tile);
                adjacentTile.lock();
            }
            if (leftBorder.equals(adjacentTile.getRightBorder())) {
                tile.setLeft(adjacentTile);
                adjacentTile.setRight(tile);
                adjacentTile.lock();
            }

            adjacentTile.rotate();
        }
    }

    public long partOne() {
        return tiles.stream()
                .filter(Tile::isEdge)
                .mapToLong(Tile::getId)
                .reduce(1L, (a, b) -> a * b);
    }

    public long partTwo() {
        Picture picture = new Picture(tiles);

        return picture.getNumberOfHashtagsThatAreNotPartOfMonsters();
    }
}
