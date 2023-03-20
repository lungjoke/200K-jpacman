package nl.tudelft.jpacman.npc.ui;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    @Test
    public void testVisibleVicetory() {
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
    @Test
    public void testButtonMainDeadCcense() {
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
    @Test
    public void testPlayAgainDeadCcense() {
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
