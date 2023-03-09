package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen
 *
 */
public class PacManUI extends JFrame {

    /**
     * Default serialisation UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The desired frame rate interval for the graphics in milliseconds, 40
     * being 25 fps.
     */
    private static final int FRAME_INTERVAL = 40;

    /**
     * The panel displaying the player scores.
     */
    private ScorePanel scorePanel;

    /**
     * The panel displaying the game.
     */
    private BoardPanel boardPanel;

    public BoardPanel getBoardPanel(){
        return this.boardPanel;
    }

    public String getNameBG(){
        return getBoardPanel().getBGName();
    }
    /**
     *contentPanel
     * */
    Container contentPanel = getContentPane();
    /**
     * scoreFormatter
     *
     * */
    private ScoreFormatter scoreFormatter;

    /**
     * Creates a new UI for a JPacman game.
     *
     * @param game
     *            The game to play.
     * @param buttons
     *            The map of caption-to-action entries that will appear as
     *            buttons on the interface.
     * @param keyMappings
     *            The map of keyCode-to-action entries that will be added as key
     *            listeners to the interface.
     * @param scoreFormatter
     *            The formatter used to display the current score.
     */
    public boolean isbuttonPlay;
    public boolean getisbuttonPlay(){
        return this.isbuttonPlay;
    }
    public JButton buttonPlay;
    public PacManUI(final Game game, final Map<String, Action> buttons,
                    final Map<Integer, Action> keyMappings,
                    ScoreFormatter scoreFormatter,String nameFileBG) {
        super("JPacman EiEi");
        assert game != null;
        assert buttons != null;
        assert keyMappings != null;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        JPanel buttonPanel = new ButtonPanel(buttons, this);

        scorePanel = new ScorePanel(game.getPlayers());
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }
        contentPanel.setLayout(new BorderLayout());
        boardPanel = new BoardPanel(game,nameFileBG);
        Main_UI(buttonPanel);
    }
    /**
     *
     * newMap
     *
     * */
    public void newMap(Game game,String nameFileBG){
        contentPanel.remove(scorePanel);
        scorePanel = new ScorePanel(game.getPlayers());
        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.remove(boardPanel);
        boardPanel = new BoardPanel(game,nameFileBG);
        contentPanel.add(boardPanel);
        pack();
    }
    /**
     *
     *
     *Main_UI
     *
     * */
    public void Main_UI(JPanel buttonPanel){
        isbuttonPlay = false;
        ImageIcon icon = new ImageIcon("src/main/resources/sprite/BGmainmenu.jpg");
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setBounds(0, 0, 500, 500);

        ImageIcon imagebtn = new ImageIcon("src/main/resources/sprite/Element_Play.png");
        this.buttonPlay = new ImageButton(imagebtn.getImage());
        this.buttonPlay.setBounds(175, 300, 150, 100);
        JPanel panel = new JPanel(null);
        click(buttonPlay,panel,buttonPanel);
        panel.add(buttonPlay);
        panel.add(label);
        add(panel);
    }
    private void click(JButton buttonPlay,JPanel panel,JPanel buttonPanel){
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        isbuttonPlay = true;
                        remove(panel);
                        pack();
                        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
                        contentPanel.add(scorePanel, BorderLayout.NORTH);
                        contentPanel.add(boardPanel, BorderLayout.CENTER);
                        pack();
                    }
                });
            }
        });
    }

    /**
     * Starts the "engine", the thread that redraws the interface at set
     * intervals.
     */
    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /**
     * Draws the next frame, i.e. refreshes the scores and game.
     */
    private void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();
    }
}
