package nl.tudelft.jpacman.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Vicetory_UI extends JFrame {
    JPanel panel = new JPanel(null);
    private PacManUI pacManUI;

    public Vicetory_UI(String victoryBg ,String mainMenu, String playAgain){
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create ImageIcon from file and scale it to fit panel size
        ImageIcon icon = new ImageIcon(victoryBg);
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        Image imageMainMenu = null;
        Image imagePlayAgain = null;
        try {
            imageMainMenu = ImageIO.read(new File(mainMenu));
            imagePlayAgain = ImageIO.read(new File(playAgain));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton toMainbtn = new ImageButton(imageMainMenu);
        JButton toPlayAgainBtn = new ImageButton(imagePlayAgain);

        toMainbtn.setBounds(100, 350, 100, 44); // Set position and size
        toPlayAgainBtn.setBounds(300, 350, 100, 44); // Set position and size

        // Create JLabel and set image icon
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500); // Set position and size

        // Add ActionListener to button
        toPlayAgainBtn.addActionListener(new ActionListener() {
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
        toMainbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        playmain(pacManUI);
                    }
                });
            }
        });
        panel.add(toMainbtn);
        panel.add(toPlayAgainBtn);
        panel.add(label);
        panel.setPreferredSize(new Dimension(scaledIcon.getIconWidth(), scaledIcon.getIconHeight()));
    }

    public JPanel getVictoryUI() {
        return panel;
    }

    public void playgame(PacManUI pacManUI) {
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(pacManUI.getScorePanel(), BorderLayout.NORTH);
        pacManUI.contentPanel.add(pacManUI.getBoardPanel(), BorderLayout.CENTER);
        pacManUI.contentPanel.add(pacManUI.getButtonPanel(), BorderLayout.SOUTH);
        pacManUI.pack();
    }
    public void playmain(PacManUI pacManUI) {
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(pacManUI.getmain_ui().getMain_UI());
        pacManUI.contentPanel.setVisible(false);
        pacManUI.contentPanel.setVisible(true);
        pacManUI.pack();
    }
    public void setPacManUI(PacManUI pacManUI){
        this.pacManUI = pacManUI;
    }
}
