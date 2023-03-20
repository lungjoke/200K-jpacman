package nl.tudelft.jpacman.npc.sprite;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResourceMapTest {
    private Launcher launcher;
    @BeforeEach
    public void SetUp(){
        launcher = new Launcher();
        launcher.launch();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    @DisplayName("TC2401")
    @Test
    public void testSkyWall() {
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/sky2.png");
    }


    @DisplayName("TC2402")
    @Test
    public void testSkyBG(){
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGsky.png");
    }

    @DisplayName("TC2403")
    @Test
    public void testSkyPellet() {
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/featherpellet.png");
    }

    @DisplayName("TC2404")
    @Test
    public void testForestWall() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Forest.png");
    }


    @DisplayName("TC2405")
    @Test
    public void testForestBG(){
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGForest.png");
    }



    @DisplayName("TC2406")
    @Test
    public void testForestPellet() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gem for.png");
    }

    @DisplayName("TC2407")
    @Test
    public void testCaveWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Stone.png");
    }



    @DisplayName("TC2408")
    @Test
    public void testCaveBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGcave.png");
    }


    @DisplayName("TC2409")
    @Test
    public void testCavePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemStone.png");
    }

    @DisplayName("TC2410")
    @Test
    public void testIceWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/ice cave.png");
    }



    @DisplayName("TC2411")
    @Test
    public void testIceBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGice.png");
    }



    @DisplayName("TC2412")
    @Test
    public void testIcePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemice.png");
    }

    @DisplayName("TC2413")
    @Test
    public void testLavaWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Lava.png");
    }


    @DisplayName("TC2414")
    @Test
    public void testLavaBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGlava.png");
    }


    @DisplayName("TC2415")
    @Test
    public void testLavaPellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemlava.png");
    }

}
