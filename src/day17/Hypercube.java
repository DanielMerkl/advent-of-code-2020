package day17;

import java.util.HashSet;
import java.util.Set;

public class Hypercube extends Cube {
    private final long w;

    public Hypercube(long x, long y, long z, long w) {
        super(x, y, z);
        this.w = w;
    }

    @Override
    public Set<Cube> getAdjacentCubes() {
        Set<Cube> adjacentCubes = new HashSet<>();

        for (long x = this.x - 1; x <= this.x + 1; x++) {
            for (long y = this.y - 1; y <= this.y + 1; y++) {
                for (long z = this.z - 1; z <= this.z + 1; z++) {
                    for (long w = this.w - 1; w <= this.w + 1; w++) {
                        if (x == this.x && y == this.y && z == this.z && w == this.w) {
                            continue;
                        }

                        adjacentCubes.add(new Hypercube(x, y, z, w));
                    }
                }
            }
        }

        return adjacentCubes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hypercube hypercube = (Hypercube) o;

        return w == hypercube.w;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (w ^ (w >>> 32));
        return result;
    }
}
