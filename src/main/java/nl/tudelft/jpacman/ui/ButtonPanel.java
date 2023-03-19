package nl.tudelft.jpacman.ui;

import org.checkerframework.checker.units.qual.C;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import static nl.tudelft.jpacman.ui.GameUI.themeNnm;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen 
 */
class ButtonPanel extends JPanel {
    private boolean isnbt =true;
    private List<JButton> bntStart = new ArrayList<JButton>();
    private List<JButton> bntStop = new ArrayList<JButton>();
    private List<String> bntname = Arrays.asList("sky","forrest","cave","ice","lava");
    private List<List<JButton>> sumbnt =  new ArrayList<List<JButton>>();
    private List<Color> colors = new ArrayList<Color>();
    private void setbnt(){
        for (int i = 0; i < 5; i++){
            bntStart.add(new ImageButton(new ImageIcon("src/main/resources/CutScense/"+bntname.get(i)+"Start.png").getImage()));
            bntStop.add(new ImageButton(new ImageIcon("src/main/resources/CutScense/"+bntname.get(i)+"Stop.png").getImage()));
        }
        sumbnt.add(bntStart);
        sumbnt.add(bntStop);
        colors.add(new Color(135,206,250));
        colors.add(new Color(46,139,87));
        colors.add(new Color(105 ,105,105));
        colors.add(new Color(173,216,230));
        colors.add(new Color(255,99,71));

    }
    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new button panel with a button for every action.
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */

    ButtonPanel(final Map<String, Action> buttons, final JFrame parent) {
        super();
        assert buttons != null;
        assert parent != null;
        if(isnbt){
            isnbt =false;
            setbnt();
        }
        int i = 0;
        for (final String caption : buttons.keySet()) {
            JButton button = sumbnt.get(i).get(themeNnm);
            button.setPreferredSize(new Dimension(90, 40)); // set the preferred size
            button.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });
            setBackground(colors.get(themeNnm));
            setPreferredSize( new Dimension( 500, 50 ) );
            add(button);
            i++;
        }
    }
}
