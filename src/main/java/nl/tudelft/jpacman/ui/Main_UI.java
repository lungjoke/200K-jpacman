
package nl.tudelft.jpacman.ui;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main_UI extends JFrame {
    private final JPanel panel = new JPanel(null);
    private JButton button2;
    public Main_UI(PacManUI pacManUI){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon scaledIcon = new ImageIcon(
            new ImageIcon("src/main/resources/sprite/BGmainmenu.png")
                .getImage()
                .getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        Image imagebtn = null;
        try {
            imagebtn = ImageIO.read(new File("src/main/resources/sprite/Element_Play.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        button2 = new ImageButton(imagebtn);
        button2.setBounds(175, 300, 150, 100);

        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500);

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
    }
    public JPanel getMain_UI(){
        return panel;
    }

    public JButton getButton2() {
        return button2;
    }

    public void playgame(PacManUI pacManUI){
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(pacManUI.getScorePanel(),BorderLayout.NORTH);
        pacManUI.contentPanel.add(pacManUI.getBoardPanel(),BorderLayout.CENTER);
        pacManUI.contentPanel.add(pacManUI.getButtonPanel(),BorderLayout.SOUTH);
        pacManUI.pack();
    }
}
