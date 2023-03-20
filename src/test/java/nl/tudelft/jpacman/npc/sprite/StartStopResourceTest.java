package nl.tudelft.jpacman.npc.sprite;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nl.tudelft.jpacman.ui.GameUI.level;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartStopResourceTest {


    private Launcher launcher;

    @BeforeEach
    public void setUp() {
        launcher = new Launcher();
        launcher.launch();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    /**
     * Test resourceStart Stop button for each map
     * */

    @DisplayName("TC2301")
    @Test
    public void startStopSkyTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        String setBtnButtonPanel = launcher.getPacManUItest().getButtonPanel().getName();
        assertThat(setBtnButtonPanel).isEqualTo("Start Stop resource from index 0");
    }

    @DisplayName("TC2302")
    @Test
    public void startStopForrestTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        String setBtnButtonPanel = launcher.getPacManUItest().getButtonPanel().getName();
        assertThat(setBtnButtonPanel).isEqualTo("Start Stop resource from index 1");
    }

    @DisplayName("TC2303")
    @Test
    public void startStopCaveTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        String setBtnButtonPanel = launcher.getPacManUItest().getButtonPanel().getName();
        assertThat(setBtnButtonPanel).isEqualTo("Start Stop resource from index 2");
    }


    @DisplayName("TC2304")
    @Test
    public void startStopIceTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        String setBtnButtonPanel = launcher.getPacManUItest().getButtonPanel().getName();
        assertThat(setBtnButtonPanel).isEqualTo("Start Stop resource from index 3");
    }

    @DisplayName("TC2305")
    @Test
    public void startStopLavaTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        String setBtnButtonPanel = launcher.getPacManUItest().getButtonPanel().getName();
        assertThat(setBtnButtonPanel).isEqualTo("Start Stop resource from index 4");
    }
}
