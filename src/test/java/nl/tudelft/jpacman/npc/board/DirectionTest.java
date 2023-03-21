package nl.tudelft.jpacman.npc.board;

import nl.tudelft.jpacman.board.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
    /**
     * Do we get the correct delta when moving north?
     */

    @DisplayName("TC601")
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaY()).isEqualTo(0);
    }

    @DisplayName("TC602")
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaY()).isEqualTo(0);
    }

    @DisplayName("TC603")
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
    }

    @DisplayName("TC604")
    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
    }

}
