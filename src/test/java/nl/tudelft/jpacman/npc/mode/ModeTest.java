package nl.tudelft.jpacman.npc.mode;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    @Test
    public void EasyModeTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(0);
    }
    @Test
    public void NormalModeTest(){
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(1);
    }

    @Test
    public void HardModeTest(){
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(level).isEqualTo(2);
    }


}
