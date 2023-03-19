package nl.tudelft.jpacman.npc.board;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PelletScoreTest {
    private Launcher launcher;

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

    @DisplayName("TC501")
    @Test
    void testWestPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 1);
        assertThat(player.getScore()).isEqualTo(10);
    }

    @DisplayName("TC502")
    @Test
    void testEastPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.EAST, 1);
        assertThat(player.getScore()).isEqualTo(10);
    }


    @DisplayName("TC503")
    @Test
    void testNorthPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.EAST, 4);
        game.move(player, Direction.NORTH);
        assertThat(player.getScore()).isEqualTo(40);
    }

    @DisplayName("TC504")
    @Test
    void testSouthPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 1);
        game.move(player, Direction.SOUTH);
        assertThat(player.getScore()).isEqualTo(10);
    }

    @DisplayName("TC601")
    @Test
    void testWestEmptyPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 1);
        game.move(player, Direction.EAST);
        game.move(player, Direction.WEST);
        assertThat(player.getScore()).isEqualTo(10);
    }


    @DisplayName("TC602")
    @Test
    void testEastEmptyPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.EAST, 1);
        game.move(player, Direction.WEST);
        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);
    }

    @DisplayName("TC603")
    @Test
    void testNorthEmptyPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.EAST, 4);
        game.move(player, Direction.NORTH);
        game.move(player, Direction.SOUTH);
        game.move(player, Direction.NORTH);
        assertThat(player.getScore()).isEqualTo(40);
    }

    @DisplayName("TC604")
    @Test
    void testSouthEmptyPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 1);
        game.move(player, Direction.SOUTH);
        game.move(player, Direction.NORTH);
        game.move(player, Direction.SOUTH);
        assertThat(player.getScore()).isEqualTo(10);
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
