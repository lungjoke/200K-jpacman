package nl.tudelft.jpacman.sprite;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.BeforeEach;
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
    public void testSkyWall() {
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/sky2.png");
    }

    @Test
    public void testForestWall() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Forest.png");
    }

    @Test
    public void testCaveWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Stone.png");
    }
    @Test
    public void testIceWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/ice cave.png");
    }

    @Test
    public void testLavaWall() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFileWall()).isEqualTo("/sprite/Lava.png");
    }

    @Test
    public void testSkyPellet() {
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/featherpellet.png");
    }
    @Test
    public void testForestPellet() {
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gem for.png");
    }
    @Test
    public void testCavePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemStone.png");
    }
    @Test
    public void testIcePellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemice.png");
    }
    @Test
    public void testLavaPellet() {
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.SPRITE_STORE.getNameFilePellet()).isEqualTo("/sprite/gemlava.png");
    }
    @Test
    public void testSkyBG(){
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGsky.png");
    }
    @Test
    public void testForestBG(){
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGForest.png");
    }
    @Test
    public void testCaveBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGcave.png");
    }
    @Test
    public void testIceBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGice.png");
    }
    @Test
    public void testLavaBG(){
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        launcher.getGame().levelWon();
        assertThat(launcher.getPacManUItest().getNameBG()).isEqualTo("src/main/resources/sprite/BGlava.png");
    }

}
