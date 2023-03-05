package nl.tudelft.jpacman.ui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainUI extends JFrame {

    public MainUI(){

        // Set JFrame properties
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel and set layout to null
        JPanel panel = new JPanel(null);

        // Create ImageIcon from file and scale it to fit panel size
        ImageIcon icon = new ImageIcon("src/main/resources/sprite/BGmainmenu.png");
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Create JLabel and set image icon
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500); // Set position and size

        // Create JButton and set text
        JButton button = new JButton("Start");
        button.setBounds(200, 200, 100, 50); // Set position and size

        // set button style
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.orange);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));

        // Add ActionListener to button
        button.addActionListener(new ActionListener() {
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
        panel.add(button);
        panel.add(label);

        // Set JPanel size to match image size
        panel.setPreferredSize(new Dimension(scaledIcon.getIconWidth(), scaledIcon.getIconHeight()));

        // Add JPanel to JFrame
        add(panel);

        //center botton
        setLocationRelativeTo(button);

        // Set JFrame visibility
        setVisible(true);


    }
    public boolean n = true;
    public boolean getStart(){
        return n;
    }
}