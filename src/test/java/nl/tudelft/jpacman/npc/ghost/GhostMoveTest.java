package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/** ghost position when ghost move.*/
public class GhostMoveTest {
    Launcher launcher;

    @BeforeEach
    void Setup(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
    }
    @AfterEach
    void tearDown() {
        launcher.dispose();
    }
    @DisplayName("TC401")
    @Test
    void testPinkyMove() {
        Ghost PinkyPosition = Navigation.findUnitInBoard(Pinky.class, launcher.getGame().getLevel().getBoard());
        //ghost position when start game
        Direction StartPosition = PinkyPosition.getDirection();
        //ghost position when ghost move
        Direction MovePosition = PinkyPosition.getDirection();
        launcher.getGame().start();
        while (StartPosition==MovePosition){
            MovePosition = Navigation.findUnitInBoard(Pinky.class, launcher.getGame().getLevel().getBoard()).getDirection();
        };
        assertThat(StartPosition!=MovePosition).isTrue();
    }
    @DisplayName("TC402")
    @Test
    void testInkyMove() {
        Ghost InkyPosition = Navigation.findUnitInBoard(Inky.class, launcher.getGame().getLevel().getBoard());
        //ghost position when start game
        Direction StartPosition = InkyPosition.getDirection();
        //ghost position when ghost move
        Direction MovePosition = InkyPosition.getDirection();
        launcher.getGame().start();
        while (StartPosition==MovePosition){
            MovePosition = Navigation.findUnitInBoard(Inky.class, launcher.getGame().getLevel().getBoard()).getDirection();
        };
        assertThat(StartPosition!=MovePosition).isTrue();
    }
    @DisplayName("TC403")
    @Test
    void testBlinkyMove() {
        Ghost BlinkyPosition = Navigation.findUnitInBoard(Blinky.class, launcher.getGame().getLevel().getBoard());
        //ghost position when start game
        Direction StartPosition = BlinkyPosition.getDirection();
        //ghost position when ghost move
        Direction MovePosition = BlinkyPosition.getDirection();
        launcher.getGame().start();
        while (StartPosition==MovePosition){
            MovePosition = Navigation.findUnitInBoard(Blinky.class, launcher.getGame().getLevel().getBoard()).getDirection();
        };
        assertThat(StartPosition!=MovePosition).isTrue();
    }
    @DisplayName("TC404")
    @Test
    void testClydeMove() {
        Ghost ClydePosition = Navigation.findUnitInBoard(Clyde.class, launcher.getGame().getLevel().getBoard());
        //ghost position when start game
        Direction StartPosition = ClydePosition.getDirection();
        //ghost position when ghost move
        Direction MovePosition = ClydePosition.getDirection();
        launcher.getGame().start();
        while (StartPosition==MovePosition){
            MovePosition = Navigation.findUnitInBoard(Clyde.class, launcher.getGame().getLevel().getBoard()).getDirection();
        };
        assertThat(StartPosition!=MovePosition).isTrue();
    }

}
