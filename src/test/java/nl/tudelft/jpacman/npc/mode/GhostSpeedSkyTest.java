package nl.tudelft.jpacman.npc.mode;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import nl.tudelft.jpacman.npc.ghost.Clyde;
import nl.tudelft.jpacman.npc.ghost.Inky;
import nl.tudelft.jpacman.npc.ghost.Pinky;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GhostSpeedSkyTest {
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

    @DisplayName("TC801")
    @Test
    public void EasyModeTest(){
        launcher.getPacManUItest().getmain_ui().getEasyBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        assertThat(p1.getName()).isEqualTo("src/main/resources/CutScense/sky2Cut.png");
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(Blinky.getMoveInterval()).isEqualTo(300);
        assertThat(Clyde.getMoveInterval()).isEqualTo(300);
        assertThat(Inky.getMoveInterval()).isEqualTo(300);
        assertThat(Pinky.getMoveInterval()).isEqualTo(300);
    }

    @DisplayName("TC802")
    @Test
    public void NormalModeTest(){
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        assertThat(p1.getName()).isEqualTo("src/main/resources/CutScense/sky2Cut.png");
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(Blinky.getMoveInterval()).isEqualTo(250);
        assertThat(Clyde.getMoveInterval()).isEqualTo(250);
        assertThat(Inky.getMoveInterval()).isEqualTo(250);
        assertThat(Pinky.getMoveInterval()).isEqualTo(250);
    }


    @DisplayName("TC803")
    @Test
    public void HardModeTest(){
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        assertThat(p1.getName()).isEqualTo("src/main/resources/CutScense/sky2Cut.png");
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        assertThat(Blinky.getMoveInterval()).isEqualTo(200);
        assertThat(Clyde.getMoveInterval()).isEqualTo(200);
        assertThat(Inky.getMoveInterval()).isEqualTo(200);
        assertThat(Pinky.getMoveInterval()).isEqualTo(200);
    }
}
