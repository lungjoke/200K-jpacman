package nl.tudelft.jpacman.npc.mode;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static nl.tudelft.jpacman.ui.GameUI.level;
import static nl.tudelft.jpacman.ui.GameUI.themeNnm;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardNormalTest {

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
    public void testNormalBoard_1() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 0"+"\nlevel: 1");
    }

    @Test
    public void testNormalBoard_2() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 1"+"\nlevel: 1");
    }

    @Test
    public void testNormalBoard_3() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.getGameUI().getCutScense().getButtonSkip().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 2"+"\nlevel: 1");
    }

    @Test
    public void testNormalBoard_4() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
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
        assertThat(p1.getName()).isEqualTo("theme: 3"+"\nlevel: 1");
    }

    @Test
    public void testNormalBoard_5() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
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
        assertThat(p1.getName()).isEqualTo("theme: 4"+"\nlevel: 1");
    }
}
