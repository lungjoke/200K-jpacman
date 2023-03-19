package nl.tudelft.jpacman.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CutScense extends JFrame {
    private JButton Skip;
    JPanel panel = new JPanel(null);
    private String Cutscense = "src/main/resources/CutScense/skyCut.png";
    private  String Skipbutton = "src/main/resources/CutScense/skySkip.png";
    private PacManUI pacManUI;
    public CutScense(String cutscense,String skipbtn) {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create ImageIcon from file and scale it to fit panel size
        ImageIcon icon = new ImageIcon(cutscense);
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        Image imagebtn = null;
        try {
            imagebtn = ImageIO.read(new File(skipbtn));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Skip = new ImageButton(imagebtn);
        Skip.setBounds(400, 440, 70, 29); // Set position and size

        // Create JLabel and set image icon
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500); // Set position and size
        // Add ActionListener to button
        Skip.addActionListener(new ActionListener() {
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
        panel.add(Skip);
        panel.add(label);
        panel.setPreferredSize(new Dimension(scaledIcon.getIconWidth(), scaledIcon.getIconHeight()));
        panel.setName(cutscense);

    }

    public JPanel getCutscenseUI() {
        return panel;
    }

    public void playgame(PacManUI pacManUI) {
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(pacManUI.getScorePanel(), BorderLayout.NORTH);
        pacManUI.contentPanel.add(pacManUI.getBoardPanel(), BorderLayout.CENTER);
        pacManUI.contentPanel.add(pacManUI.getButtonPanel(), BorderLayout.SOUTH);
        pacManUI.pack();
    }

    public void setPacManUI(PacManUI pacManUI){
        this.pacManUI = pacManUI;
    }
    public JButton getButtonSkip() {
        return Skip;
    }
}


