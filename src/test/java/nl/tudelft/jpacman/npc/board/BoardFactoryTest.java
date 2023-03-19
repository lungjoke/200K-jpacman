package nl.tudelft.jpacman.npc.board;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Tests the linking of squares done by the board factory.
 *
 * @author Jeroen Roosen 
 */
class BoardFactoryTest {

    /**
     * The factory under test.
     */
    private BoardFactory factory;

    /**
     * Square on the board to test.
     */
    private Square s1;

    /**
     * Square on the board to test.
     */
    private Square s2;

    /**
     * Resets the factory under test.
     */
    @BeforeEach
    void setUp() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();
    }

    /**
     * Verifies that a single cell is connected to itself on all sides.
     */


    @DisplayName("TC1801")
    @Test
    void worldIsRound() {
        factory.createBoard(new Square[][]{{s1}});
        assertThat(Arrays.stream(Direction.values()).map(s1::getSquareAt)).containsOnly(s1);
    }

    /**
     * Verifies a chain of cells is connected to the east.
     */

    @DisplayName("TC1901")
    @Test
    void connectedEast() {
        factory.createBoard(new Square[][]{{s1}, {s2}});
        assertThat(s1.getSquareAt(Direction.EAST)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.EAST)).isEqualTo(s1);
    }

    /**
     * Verifies a chain of cells is connected to the west.
     */

    @DisplayName("TC2001")
    @Test
    void connectedWest() {
        factory.createBoard(new Square[][]{{s1}, {s2}});
        assertThat(s1.getSquareAt(Direction.WEST)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.WEST)).isEqualTo(s1);
    }

    /**
     * Verifies a chain of cells is connected to the north.
     */

    @DisplayName("TC2101")
    @Test
    void connectedNorth() {
        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s1.getSquareAt(Direction.NORTH)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.NORTH)).isEqualTo(s1);
    }

    /**
     * Verifies a chain of cells is connected to the south.
     */

    @DisplayName("TC2201")
    @Test
    void connectedSouth() {
        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s1.getSquareAt(Direction.SOUTH)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.SOUTH)).isEqualTo(s1);
    }

}
