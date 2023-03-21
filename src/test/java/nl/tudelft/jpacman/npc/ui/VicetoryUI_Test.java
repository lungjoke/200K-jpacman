package nl.tudelft.jpacman.npc.ui;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VicetoryUI_Test {
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

    @DisplayName("TC1601")
    @Test
    public void testVisibleVictory() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("Vicetory");
    }

    @DisplayName("TC1801")
    @Test
    public void testButtonMainDeadVictory() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.getGameUI().getVicetory_ui().getToMainbtn().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("main");
    }

    @DisplayName("TC1901")
    @Test
    public void testPlayAgainDeadVictory() {
        launcher.getPacManUItest().getmain_ui().getNormalBtn().doClick();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        launcher.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.won();
        launcher.getGameUI().getVicetory_ui().getToPlayAgainBtn().doClick();
        launcher.delay(1000);
        JPanel p1 = (JPanel) launcher.getPacManUItest().getContentPanel().getComponent(1);
        System.out.println(p1.getName());
        assertThat(p1.getName()).isEqualTo("theme: 0"+"\nlevel: 1");
    }
}
