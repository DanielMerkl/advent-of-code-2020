package day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class LobbyLayout {
    private Map<Tile, ColorFacingUp> tiles;

    private LobbyLayout(Map<Tile, ColorFacingUp> tiles) {
        this.tiles = tiles;
    }

    static LobbyLayout from(String input) {
        List<TilePath> tilePaths = input.lines()
                .map(TilePath::from)
                .collect(Collectors.toList());

        HashMap<Tile, ColorFacingUp> tiles = new HashMap<>();

        for (TilePath tilePath : tilePaths) {
            Tile currentTile = new Tile(0, 0);

            for (Direction direction : tilePath.getDirections()) {
                currentTile = currentTile.getAdjacentTile(direction);
            }

            tiles.computeIfPresent(currentTile, (_tile, colorFacingUp) -> switch (colorFacingUp) {
                case BLACK -> ColorFacingUp.WHITE;
                case WHITE -> ColorFacingUp.BLACK;
            });
            tiles.putIfAbsent(currentTile, ColorFacingUp.BLACK);
        }

        return new LobbyLayout(tiles);
    }

    long partOne() {
        return numberOfTilesLeftWithBlackSideUp();
    }

    private long numberOfTilesLeftWithBlackSideUp() {
        return tiles.values()
                .stream()
                .filter(colorFacingUp -> colorFacingUp == ColorFacingUp.BLACK)
                .count();
    }

    long partTwo(int numberOfExecutions) {
        for (int n = 0; n < numberOfExecutions; n++) {
            addPossiblyMissingTiles();
            executeRules();
        }

        return numberOfTilesLeftWithBlackSideUp();
    }

    private void addPossiblyMissingTiles() {
        List<Tile> tilesWithBlackSideFacingUp = tiles.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == ColorFacingUp.BLACK)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (Tile tileWithBlackSideFacingUp : tilesWithBlackSideFacingUp) {
            Set<Tile> adjacentTiles = tileWithBlackSideFacingUp.getAllAdjacentTiles();
            for (Tile adjacentTile : adjacentTiles) {
                tiles.putIfAbsent(adjacentTile, ColorFacingUp.WHITE);
            }
        }
    }

    private void executeRules() {
        Map<Tile, ColorFacingUp> updatedTiles = new HashMap<>();

        tiles.forEach((tile, colorFacingUp) -> {
            long numberOfAdjacentBlackTiles = tile.getAllAdjacentTiles()
                    .stream()
                    .filter(adjacentTile -> tiles.get(adjacentTile) == ColorFacingUp.BLACK)
                    .count();
            switch (colorFacingUp) {
                case BLACK -> {
                    if (numberOfAdjacentBlackTiles == 0 || numberOfAdjacentBlackTiles > 2) {
                        colorFacingUp = ColorFacingUp.WHITE;
                    }
                }
                case WHITE -> {
                    if (numberOfAdjacentBlackTiles == 2) {
                        colorFacingUp = ColorFacingUp.BLACK;
                    }
                }
            }

            updatedTiles.put(tile, colorFacingUp);
        });

        tiles = updatedTiles;
    }
}
