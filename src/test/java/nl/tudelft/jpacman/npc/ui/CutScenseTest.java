package nl.tudelft.jpacman.npc.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.CutScense;
import nl.tudelft.jpacman.ui.PacManUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


import static org.junit.jupiter.api.Assertions.*;


public class CutScenseTest {

    private CutScense cutScense;
    private PacManUI pacManUI;
    private Launcher launcher;
    @BeforeEach
    public void setUp() {
        cutScense = new CutScense("src/main/resources/CutScense/skyCut.png",
            "src/main/resources/CutScense/skySkip.png");
        launcher = new Launcher();
        launcher.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        pacManUI = launcher.getPacManUItest();
        cutScense.setPacManUI(pacManUI);
    }

    @Test
    public void testGetCutscenseUI() {
        //JPanel panel = cutScense.getCutscenseUI();
        JPanel panel = launcher.getPacManUItest().getmain_ui().getCutScense().getCutscenseUI();
        assertNotNull(panel);
        assertEquals(new Dimension(500, 500), panel.getPreferredSize());
        assertEquals(null, panel.getLayout());
    }

    @Test
    public void testPlaygame() {
        pacManUI.getContentPanel().add(new JLabel("Test Label"));
        cutScense.playgame(pacManUI);
        assertEquals(2, pacManUI.getContentPanel().getComponentCount());
        assertNotNull(pacManUI.getScorePanel());
        assertNotNull(pacManUI.getBoardPanel());
        assertNotNull(pacManUI.getButtonPanel());
    }

    @Test
    public void testGetButtonSkip() {
        JButton skipButton = cutScense.getButtonSkip();
        assertNotNull(skipButton);
        assertTrue(skipButton.isVisible());

        skipButton.getActionListeners()[0].actionPerformed(new ActionEvent(this, 0, ""));
        assertEquals(2, pacManUI.getContentPanel().getComponentCount());
        assertNotNull(pacManUI.getScorePanel());
        assertNotNull(pacManUI.getBoardPanel());
        assertNotNull(pacManUI.getButtonPanel());
    }
}

