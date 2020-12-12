package day12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void initializesCorrectly() {
        Ship ship = new Ship();

        assertEquals(0, ship.getX());
        assertEquals(0, ship.getY());
        assertEquals(Orientation.EAST, ship.getOrientation());
    }

    @Test
    void move_north() {
        Ship ship = new Ship();

        ship.move(Orientation.NORTH, 1);

        assertEquals(0, ship.getX());
        assertEquals(1, ship.getY());
    }

    @Test
    void move_east() {
        Ship ship = new Ship();

        ship.move(Orientation.EAST, 1);

        assertEquals(1, ship.getX());
        assertEquals(0, ship.getY());
    }

    @Test
    void move_south() {
        Ship ship = new Ship();

        ship.move(Orientation.SOUTH, 1);

        assertEquals(0, ship.getX());
        assertEquals(-1, ship.getY());
    }

    @Test
    void move_west() {
        Ship ship = new Ship();

        ship.move(Orientation.WEST, 1);

        assertEquals(-1, ship.getX());
        assertEquals(0, ship.getY());
    }

    @ParameterizedTest
    @MethodSource("getTurnLeftArguments")
    void turnLeft(int degree, Orientation expectedOrientation) {
        Ship ship = new Ship();

        assertEquals(Orientation.EAST, ship.getOrientation());

        ship.turnLeft(degree);

        assertEquals(expectedOrientation, ship.getOrientation());
    }

    private static Stream<Arguments> getTurnLeftArguments() {
        return Stream.of(
                Arguments.of(90, Orientation.NORTH),
                Arguments.of(180, Orientation.WEST),
                Arguments.of(270, Orientation.SOUTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getTurnRightArguments")
    void turnRight(int degree, Orientation expectedOrientation) {
        Ship ship = new Ship();

        assertEquals(Orientation.EAST, ship.getOrientation());

        ship.turnRight(degree);

        assertEquals(expectedOrientation, ship.getOrientation());
    }

    private static Stream<Arguments> getTurnRightArguments() {
        return Stream.of(
                Arguments.of(90, Orientation.SOUTH),
                Arguments.of(180, Orientation.WEST),
                Arguments.of(270, Orientation.NORTH)
        );
    }

    @Test
    void getManhattanDistanceFromStartingPoint() {
        Ship ship = new Ship();

        ship.move(Orientation.NORTH, 10);
        ship.move(Orientation.EAST, -5);
        int result = ship.getManhattanDistanceFromStartingPoint();

        assertEquals(15, result);
    }

    @Test
    void moveForward() {
        Ship ship = new Ship();

        ship.moveForward(1);

        assertEquals(1, ship.getX());
        assertEquals(0, ship.getY());

        ship.turnRight(90);
        ship.moveForward(1);

        assertEquals(1, ship.getX());
        assertEquals(-1, ship.getY());

        ship.turnRight(90);
        ship.moveForward(1);

        assertEquals(0, ship.getX());
        assertEquals(-1, ship.getY());

        ship.turnRight(90);
        ship.moveForward(1);

        assertEquals(0, ship.getX());
        assertEquals(0, ship.getY());
    }

    @Test
    void moveForwardWithWaypoint() {
        Ship ship = new Ship();
        Waypoint waypoint = new Waypoint(5, 2);

        ship.moveForward(2, waypoint);

        assertEquals(10, ship.getX());
        assertEquals(4, ship.getY());
    }

}
