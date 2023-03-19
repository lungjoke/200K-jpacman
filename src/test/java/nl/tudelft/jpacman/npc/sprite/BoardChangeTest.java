package nl.tudelft.jpacman.npc.sprite;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.sprite.SpriteStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardChangeTest {

    private Sprite sprite;
    private SpriteStore store;
    private Launcher launcher;

    @BeforeEach
    public void setup(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().getmain_ui().getButton2().doClick();
    }

    @DisplayName("TC1501")
    @Test
    public void testBoardSky() {
        assertThat(launcher.getLevelMap()).isEqualTo("/skyboard.txt");
    }

    @DisplayName("TC1502")
    @Test
    public void testBoardForest (){
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/forest.txt");
    }
    @DisplayName("TC1503")
    @Test
    public void testBoardcave(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/caveboard.txt");
    }

    @DisplayName("TC1504")
    @Test
    public void testBoardice(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/iceboard.txt");
    }

    @DisplayName("TC1505")
    @Test
    public void testBoardlava(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getLevelMap()).isEqualTo("/lavaboard.txt");
    }

}

