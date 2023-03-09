package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.Test;

public class PelletScoreTest {
    private Launcher launcher;

    @BeforeEach
    public void setup(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().buttonPlay.doClick();


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
        assertThat(player.getScore()).isEqualTo(50);
    }

    @DisplayName("TC504")
    @Test
    void testSouthPellet() {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        move(game, Direction.WEST, 1);
        game.move(player, Direction.SOUTH);
        assertThat(player.getScore()).isEqualTo(20);
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
        assertThat(player.getScore()).isEqualTo(50);
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
        assertThat(player.getScore()).isEqualTo(20);
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
