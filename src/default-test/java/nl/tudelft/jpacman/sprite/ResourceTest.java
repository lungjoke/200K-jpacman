package nl.tudelft.jpacman.sprite;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResourceTest {
    private Launcher launcher;
    @BeforeEach
    public void SetUp(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().buttonPlay.doClick();
    }

    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        Assertions.assertThat(east.getDeltaY()).isEqualTo(0);
    }

    @DisplayName("TC1401")
    @Test
    public void testSkyWall() {
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/sky2.png");
    }


    @DisplayName("TC1402")
    @Test
    public void testSkyBG(){
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGsky.png");
    }

    @DisplayName("TC1403")
    @Test
    public void testSkyPellet() {
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/featherpellet.png");
    }

    @DisplayName("TC1404")
    @Test
    public void testForestWall() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Forest.png");
    }


    @DisplayName("TC1405")
    @Test
    public void testForestBG(){
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGForest.png");
    }



    @DisplayName("TC1406")
    @Test
    public void testForestPellet() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gem for.png");
    }

    @DisplayName("TC1407")
    @Test
    public void testCaveWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Stone.png");
    }



    @DisplayName("TC1408")
    @Test
    public void testCaveBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGcave.png");
    }


    @DisplayName("TC1409")
    @Test
    public void testCavePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemStone.png");
    }

    @DisplayName("TC1410")
    @Test
    public void testIceWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/ice cave.png");
    }



    @DisplayName("TC1411")
    @Test
    public void testIceBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGice.png");
    }



    @DisplayName("TC1412")
    @Test
    public void testIcePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemice.png");
    }

    @DisplayName("TC1413")
    @Test
    public void testLavaWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Lava.png");
    }


    @DisplayName("TC1414")
    @Test
    public void testLavaBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGlava.png");
    }


    @DisplayName("TC1415")
    @Test
    public void testLavaPellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemlava.png");
    }

}
