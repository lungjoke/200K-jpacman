package nl.tudelft.jpacman.npc.mode;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static nl.tudelft.jpacman.ui.GameUI.level;
import static nl.tudelft.jpacman.ui.GameUI.themeNnm;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardHardTest {

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

    @Test
    public void testHardBoard_1() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 0"+"\nlevel: 2");
    }

    @Test
    public void testHardBoard_2() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 1"+"\nlevel: 2");
    }

    @Test
    public void testHardBoard_3() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 2"+"\nlevel: 2");
    }

    @Test
    public void testHardBoard_4() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 3"+"\nlevel: 2");
    }

    @Test
    public void testHardBoard_5() {
        launcher.getPacManUItest().getmain_ui().getHardBtn().doClick();
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
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 4"+"\nlevel: 2");
    }
}
