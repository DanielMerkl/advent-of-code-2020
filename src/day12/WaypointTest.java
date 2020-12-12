package day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaypointTest {

    @Test
    void initializesCorrectly() {
        Waypoint waypoint = new Waypoint(10, 1);

        assertEquals(10, waypoint.getX());
        assertEquals(1, waypoint.getY());
    }

    @Test
    void move_north() {
        Waypoint waypoint = new Waypoint(0, 0);

        waypoint.move(Orientation.NORTH, 1);

        assertEquals(0, waypoint.getX());
        assertEquals(1, waypoint.getY());
    }

    @Test
    void move_east() {
        Waypoint waypoint = new Waypoint(0, 0);

        waypoint.move(Orientation.EAST, 1);

        assertEquals(1, waypoint.getX());
        assertEquals(0, waypoint.getY());
    }

    @Test
    void move_south() {
        Waypoint waypoint = new Waypoint(0, 0);

        waypoint.move(Orientation.SOUTH, 1);

        assertEquals(0, waypoint.getX());
        assertEquals(-1, waypoint.getY());
    }

    @Test
    void move_west() {
        Waypoint waypoint = new Waypoint(0, 0);

        waypoint.move(Orientation.WEST, 1);

        assertEquals(-1, waypoint.getX());
        assertEquals(0, waypoint.getY());
    }

    @Test
    void rotateLeft_90() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateLeft(90);

        assertEquals(-1, waypoint.getX());
        assertEquals(1, waypoint.getY());
    }

    @Test
    void rotateLeft_180() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateLeft(180);

        assertEquals(-1, waypoint.getX());
        assertEquals(-1, waypoint.getY());
    }

    @Test
    void rotateLeft_270() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateLeft(270);

        assertEquals(1, waypoint.getX());
        assertEquals(-1, waypoint.getY());
    }

    @Test
    void rotateRight_90() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateRight(90);

        assertEquals(1, waypoint.getX());
        assertEquals(-1, waypoint.getY());
    }

    @Test
    void rotateRight_180() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateRight(180);

        assertEquals(-1, waypoint.getX());
        assertEquals(-1, waypoint.getY());
    }

    @Test
    void rotateRight_270() {
        Waypoint waypoint = new Waypoint(1, 1);

        waypoint.rotateRight(270);

        assertEquals(-1, waypoint.getX());
        assertEquals(1, waypoint.getY());
    }

}
