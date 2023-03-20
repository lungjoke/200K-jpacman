package nl.tudelft.jpacman.npc.ui;

import nl.tudelft.jpacman.Launcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainUITest {
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
    public void MainUITest(){
        JPanel l1 =(JPanel) launcher.getPacManUItest().getContentPanel().getComponent(0);
        assertThat(l1.getName()).isEqualTo("main");
        assertThat(l1.getComponentCount()).isEqualTo(5);
    }
}
