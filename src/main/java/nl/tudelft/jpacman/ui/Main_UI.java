
package nl.tudelft.jpacman.ui;



import nl.tudelft.jpacman.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main_UI extends JFrame {
    private Launcher launcher;
    private final JPanel panel = new JPanel(null);

    private JButton ButtonPlay;
    private JButton EasyBtn;
    private JButton NormalBtn;
    private JButton HardBtn;
    private CutScense cutScense;
    private boolean isbntEasy = false;
    private boolean isbntNormal = true;
    private boolean isbntHard= true;
    private boolean isbuttonPlay = true;

    private JLabel label = new JLabel();

    public Main_UI(PacManUI pacManUI){
        cutScense = new CutScense("src/main/resources/CutScense/sky2Cut.png","src/main/resources/CutScense/Skipblack.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon scaledIcon = new ImageIcon(
            new ImageIcon("src/main/resources/sprite/BGmainUI.png")
                .getImage()
                .getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        Image imagebtn = null;
        try {
            imagebtn = ImageIO.read(new File("src/main/resources/sprite/PlayBtn.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ButtonPlay = new ImageButton(imagebtn);
        ButtonPlay.setBounds(175, 330, 150, 60);
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500);
        setmainBnt();
        setaddPanel();
        panel.setPreferredSize(new Dimension(500,500));
        addclick(pacManUI);
        ButtonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        launcher.lost();
                        cutScense.setPacManUI(launcher.getPacManUItest());
                        ToCut(pacManUI);
                    }
                });
            }
        });
    }
    public void addclick(PacManUI pacManUI){
        NormalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        resetbnt();
                        isbntNormal = false;
                        setaddall(pacManUI);
                    }
                });
            }
        });
        EasyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        resetbnt();
                        isbntEasy = false;
                        setaddall(pacManUI);
                    }
                });
            }
        });
        HardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        resetbnt();
                        isbntHard = false;
                        setaddall(pacManUI);
                    }
                });
            }
        });
    }

    public JPanel getMain_UI(){
        return panel;
    }

    public void ToCut(PacManUI pacManUI){
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(cutScense.getCutscenseUI());
        pacManUI.pack();
        pacManUI.contentPanel.setVisible(false);
        pacManUI.contentPanel.setVisible(true);
    }

    public void setmainBnt(){
        if (isbntEasy){
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/EasyBtn.png");
            EasyBtn = new ImageButton(imagebtn.getImage());
            EasyBtn.setBounds(50, 180, 130, 50);
        }else {
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/EasyBtn2.png");
            EasyBtn = new ImageButton(imagebtn.getImage());
            EasyBtn.setBounds(50, 180, 130, 50);
            GameUI.level = 0;
        }
        if(isbntNormal){
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/NormalBtn.png");
            NormalBtn = new ImageButton(imagebtn.getImage());
            NormalBtn.setBounds(185, 250, 130, 50);
        }else {
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/NormalBtn2.png");
            NormalBtn = new ImageButton(imagebtn.getImage());
            NormalBtn.setBounds(185, 250, 130, 50);
            GameUI.level = 1;
        }
        if(isbntHard){
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/HardBtn.png");
            HardBtn = new ImageButton(imagebtn.getImage());
            HardBtn.setBounds(315, 180, 130, 50);
        }else {
            ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/HardBtn2.png");
            HardBtn = new ImageButton(imagebtn.getImage());
            HardBtn.setBounds(315, 180, 130, 50);
            GameUI.level = 2;
        }
    }
    public void resetbnt(){
        isbntEasy = true;
        isbntNormal = true;
        isbntHard = true;
    }
    public void setaddPanel(){
        panel.add(HardBtn,0);
        panel.add(NormalBtn,1);
        panel.add(EasyBtn,2);
        panel.add(ButtonPlay,3);
        panel.add(label,4);
        panel.setName("main");
    }
    public void setaddall(PacManUI pacManUI){
        setmainBnt();
        addclick(pacManUI);
        setaddPanel();
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(panel);
        pacManUI.pack();
        pacManUI.contentPanel.setVisible(false);
        pacManUI.contentPanel.setVisible(true);
    }

    public void setLauncher(Launcher launcher) {
        this.launcher = launcher;
    }

    public CutScense getCutScense(){
        return cutScense;
    }

    public JButton getEasyBtn() {
        return EasyBtn;
    }

    public JButton getNormalBtn() {
        return NormalBtn;
    }

    public JButton getHardBtn() {
        return HardBtn;
    }

    public JButton getButtonPlay() {
        return ButtonPlay;
    }

    public boolean isIsbuttonPlay() {
        return isbuttonPlay;
    }
}
