package nl.tudelft.jpacman.npc.board;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollisionWallTest {
    private Launcher launcher;

    private Square square;

    /**
     * Resets the square under test.
     */
    @BeforeEach
    void setUp() {
        square = new BasicSquare();
    }

    @BeforeEach
    public void setup(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();

    }
    @AfterEach
    void tearDown() {
        launcher.dispose();
    }


    /** Move as far as it can, if the number of pellet not equal to the number in row from that direction it means that we found wall*/
    @DisplayName("TC701")
    @Test
    void westWall(){
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 11);
        assertThat(player.getScore()).isEqualTo(60);
    }

    /** Move as far as it can, if the number of pellet not equal to the number in row from that direction it means that we found wall*/
    @DisplayName("TC702")
    @Test
    void eastWall(){
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.EAST, 11);
        assertThat(player.getScore()).isEqualTo(60);
    }

    /** Move as far as it can in row or column start from pacman position,
     * if the number of pellet not equal to the number in row from that direction it means that we found wall*/
    @DisplayName("TC703")
    @Test
    void northWall(){
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.NORTH, 15);
        assertThat(player.getScore()).isEqualTo(0);
    }

    /** Move as far as it can, if the number of pellet not equal to the number in row from that direction it means that we found wall*/
    @DisplayName("TC704")
    @Test
    void southWall(){
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.NORTH, 5);
        assertThat(player.getScore()).isEqualTo(0);
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }

}
