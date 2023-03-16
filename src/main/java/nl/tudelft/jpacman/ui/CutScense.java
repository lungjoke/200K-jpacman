package nl.tudelft.jpacman.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CutScense extends JFrame {
    JPanel panel = new JPanel(null);

    private String Cutscense;
    private  String Skipbutton;


    public CutScense(PacManUI pacManUI) {

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create ImageIcon from file and scale it to fit panel size
        ImageIcon icon = new ImageIcon(Cutscense);
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        Image imagebtn = null;
        try {
            imagebtn = ImageIO.read(new File(Skipbutton));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton button2 = new ImageButton(imagebtn);
        button2.setBounds(175, 300, 150, 100); // Set position and size

        // Create JLabel and set image icon
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500); // Set position and size

        // Add ActionListener to button
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        playgame(pacManUI);
                    }
                });
            }
        });


        panel.add(button2);
        panel.add(label);
        panel.setPreferredSize(new Dimension(scaledIcon.getIconWidth(), scaledIcon.getIconHeight()));
        add(panel);

        setVisible(true);
    }

    public JPanel getMain_UI() {
        return panel;
    }

    public void playgame(PacManUI pacManUI) {
        pacManUI.contentPanel.removeAll();
        //pacManUI.pack();
        pacManUI.contentPanel.add(pacManUI.getScorePanel(), BorderLayout.NORTH);
        pacManUI.contentPanel.add(pacManUI.getBoardPanel(), BorderLayout.CENTER);
        pacManUI.contentPanel.add(pacManUI.getButtonPanel(), BorderLayout.SOUTH);
        pacManUI.pack();
    }

    public String getCutscense() {
        return Cutscense;
    }
    public String getSkipbutton() {
        return Cutscense;
    }
}


