package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

class ImageButton extends JButton {
    private Image backgroundImage;

    public ImageButton(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
