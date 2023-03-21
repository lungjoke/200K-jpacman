package nl.tudelft.jpacman.npc.mode;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static nl.tudelft.jpacman.ui.GameUI.level;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModeTest {
    private Launcher launcher;

    @BeforeEach
    public void SetUp(){
        launcher = new Launcher();
        launcher.launch();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    @DisplayName("TC301")
    @Test
    public void PlayWithoutSelectModeTest(){
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(0);
    }

    @DisplayName("TC302")
    @Test
    public void EasyModeTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(0);
    }

    @DisplayName("TC303")
    @Test
    public void NormalModeTest(){
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(1);
    }

    @DisplayName("TC304")
    @Test
    public void HardModeTest(){
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(2);
    }

    @DisplayName("TC501")
    @Test
    public void testStartGame() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();

        launcher.getGame().start();
        assertThat(launcher.getGame().isInProgress());
    }


}
