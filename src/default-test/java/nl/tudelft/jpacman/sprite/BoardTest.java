package nl.tudelft.jpacman.sprite;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Sprite sprite;
    private SpriteStore store;
    private Launcher launcher;

    @BeforeEach
    public void setup(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().buttonPlay.doClick();
    }
    @Test
    public void testBoardSky() {
        assertThat(launcher.getLevelMap()).isEqualTo("/skyboard.txt");
    }
    @Test
    public void testBoardForest (){
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/forest.txt");
    }
    @Test
    public void testBoardcave(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/caveboard.txt");
    }
    @Test
    public void testBoardice(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/iceboard.txt");
    }
    @Test
    public void testBoardlava(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/lavaboard.txt");
    }

}

