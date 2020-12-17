package day17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConwayCubes {
    private Map<Cube, Boolean> cubes = new HashMap<>();

    public ConwayCubes(String input, boolean withHypercubes) {
        String[] lines = input.split("\n");

        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            char[] charArray = line.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                Cube cube = withHypercubes ? new Hypercube(x, y, 0, 0) : new Cube(x, y, 0);
                char c = charArray[x];
                switch (c) {
                    case '.' -> cubes.put(cube, false);
                    case '#' -> cubes.put(cube, true);
                    default -> throw new RuntimeException("unexpected character: " + c);
                }
            }
        }
    }

    public void simulateCycles(int n) {
        for (int i = 0; i < n; i++) {
            addPossiblyMissingCubes();
            HashMap<Cube, Boolean> updatedCubes = new HashMap<>();

            cubes.forEach((cube, active) -> {
                long numberOfActiveAdjacentCubes = getNumberOfActiveAdjacentCubes(cube);
                if (active) {
                    if (numberOfActiveAdjacentCubes != 2 && numberOfActiveAdjacentCubes != 3) {
                        active = false;
                    }
                } else {
                    if (numberOfActiveAdjacentCubes == 3) {
                        active = true;
                    }
                }
                updatedCubes.put(cube, active);
            });

            cubes = updatedCubes;
        }
    }

    private long getNumberOfActiveAdjacentCubes(Cube cube) {
        int numberOfActiveAdjacentCubes = 0;
        Set<Cube> adjacentCubes = cube.getAdjacentCubes();

        for (Cube adjacentCube : adjacentCubes) {
            Boolean adjacentCubeIsActive = cubes.getOrDefault(adjacentCube, false);
            if (adjacentCubeIsActive) {
                numberOfActiveAdjacentCubes++;
            }
        }

        return numberOfActiveAdjacentCubes;
    }

    private void addPossiblyMissingCubes() {
        Set<Cube> possiblyMissingCubes = new HashSet<>();

        cubes.forEach((cube, active) -> {
            if (active) {
                Set<Cube> adjacentCubes = cube.getAdjacentCubes();
                possiblyMissingCubes.addAll(adjacentCubes);
            }
        });

        for (Cube possiblyMissingCube : possiblyMissingCubes) {
            cubes.putIfAbsent(possiblyMissingCube, false);
        }
    }

    public long getNumberOfActiveCubes() {
        return cubes.values()
                .stream()
                .filter(active -> active)
                .count();
    }
}
