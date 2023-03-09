package nl.tudelft.jpacman.board;

import com.google.common.collect.Lists;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.*;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

/** find ghost in board. */

public class FindUnitInBoardTest {

    private MapParser parser;

    @BeforeEach
    void setUp() {
        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            mock(PointCalculator.class));
        parser = new MapParser(levelFactory, new BoardFactory(sprites));
    }

    @Test
    void testFindPinkyInBoard(){
        Board b = parser.parseMap(Lists.newArrayList("G G G G")).getBoard();
        Ghost foundPinky = Navigation.findUnitInBoard(Pinky.class, b);

        System.out.println(foundPinky.getDirection());

        assertThat(foundPinky).isNotNull();
    }

    @Test
    void testFindInkyInBoard(){
        Board b = parser.parseMap(Lists.newArrayList("G G G G")).getBoard();
        Ghost foundInky = Navigation.findUnitInBoard(Inky.class, b);

        assertThat(foundInky).isNotNull();
    }

    @Test
    void testFindBlinkyInBoard(){
        Board b = parser.parseMap(Lists.newArrayList("G G G G")).getBoard();
        Ghost foundBlinky = Navigation.findUnitInBoard(Blinky.class, b);

        assertThat(foundBlinky).isNotNull();
    }

    @Test
    void testFindClydeInBoard(){
        Board b = parser.parseMap(Lists.newArrayList("G G G G")).getBoard();
        Ghost foundClyde = Navigation.findUnitInBoard(Clyde.class, b);

        assertThat(foundClyde).isNotNull();
    }

}
