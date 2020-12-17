package day17;

import java.util.HashSet;
import java.util.Set;

public class Cube {
    protected final long x;
    protected final long y;
    protected final long z;

    public Cube(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Set<Cube> getAdjacentCubes() {
        Set<Cube> adjacentCubes = new HashSet<>();

        for (long x = this.x - 1; x <= this.x + 1; x++) {
            for (long y = this.y - 1; y <= this.y + 1; y++) {
                for (long z = this.z - 1; z <= this.z + 1; z++) {
                    if (x == this.x && y == this.y && z == this.z) {
                        continue;
                    }

                    adjacentCubes.add(new Cube(x, y, z));
                }
            }
        }

        return adjacentCubes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (x != cube.x) return false;
        if (y != cube.y) return false;
        return z == cube.z;
    }

    @Override
    public int hashCode() {
        int result = (int) (x ^ (x >>> 32));
        result = 31 * result + (int) (y ^ (y >>> 32));
        result = 31 * result + (int) (z ^ (z >>> 32));
        return result;
    }
}
