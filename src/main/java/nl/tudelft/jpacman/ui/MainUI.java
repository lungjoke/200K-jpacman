package nl.tudelft.jpacman.ui;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class MainUI extends JFrame {

    public MainUI() throws IOException {

        // Set JFrame properties
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel and set layout to null
        JPanel panel = new JPanel(null);

        // Create ImageIcon from file and scale it to fit panel size
        ImageIcon icon = new ImageIcon("src/main/resources/sprite/BGmainmenu.png");
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        Image imagebtn = ImageIO.read(new File("src/main/resources/sprite/Element_Play.png"));
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
                        n = false;

                    }

                });
            }
        });
        // Add JLabel and JButton to JPanel

        panel.add(button2);
        panel.add(label);

        // Set JPanel size to match image size
        panel.setPreferredSize(new Dimension(scaledIcon.getIconWidth(), scaledIcon.getIconHeight()));

        // Add JPanel to JFrame
        add(panel);

        // Set JFrame visibility
        setLocationRelativeTo(null);
        setVisible(true);



    }
    public boolean n = true;
    public boolean getStart(){
        return n;
    }
}