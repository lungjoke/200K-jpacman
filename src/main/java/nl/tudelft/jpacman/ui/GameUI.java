package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.npc.ghost.Blinky;
import nl.tudelft.jpacman.npc.ghost.Clyde;
import nl.tudelft.jpacman.npc.ghost.Inky;
import nl.tudelft.jpacman.npc.ghost.Pinky;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameUI {

    private boolean levelup=false;
    /**
     * A list of lists representing the game board.
     * */
    private List<List<String>> board =  new ArrayList<List<String>>();
    private List<CutScense> cut = new ArrayList<CutScense>();
    Vicetory_UI vicetory_ui = new Vicetory_UI("src/main/resources/WinLostBoard/gameWin.png",
                                             "src/main/resources/WinLostBoard/toMain.png",
                                              "src/main/resources/WinLostBoard/playAgain.png");
    Deadscense deadscense = new Deadscense("src/main/resources/WinLostBoard/gameLose.png", "src/main/resources/WinLostBoard/toMain.png", "src/main/resources/WinLostBoard/playAgain.png");
    /**
     *  A list of strings representing the wall sprites.
     * */
    private List<String> Wall = Arrays.asList("/sky2.png", "/Forest.png", "/Stone.png","/ice cave.png","/Lava.png");
    /**
     * A list of strings representing the pellet sprites.
     * */
    private List<String> Pellet = Arrays.asList("/featherpellet.png", "/gem for.png", "/gemStone.png","/gemice.png","/gemlava.png");
    /**
     *  A list of strings representing the background sprites.
     * */
    private List<String> BG = Arrays.asList("/BGsky.png", "/BGForest.png", "/BGcave.png","/BGice.png","/BGlava.png");
    /**
     *  A list of floating-point numbers representing the level multiplier for each level.
     * */
    private List<Integer> levelnum = new ArrayList<Integer>();
    /**
     * An integer representing the current level.
     * */
    public static int level;
    /**
     *An integer representing the current board number.
     * */
    private int BoardNnm;
    /**
     *An integer representing the current theme number.
     * */
    public static int themeNnm;
    /**
     * GameUI()
     * */

    public GameUI(){
        cut.add(new CutScense("src/main/resources/CutScense/skyCut.png","src/main/resources/CutScense/Skipblack.png"));
        cut.add(new CutScense("src/main/resources/CutScense/forrestCut.png","src/main/resources/CutScense/Skipwhite.png"));
        cut.add(new CutScense("src/main/resources/CutScense/caveCut.png","src/main/resources/CutScense/Skipwhite.png"));
        cut.add(new CutScense("src/main/resources/CutScense/iceCut.png","src/main/resources/CutScense/Skipwhite.png"));
        cut.add(new CutScense("src/main/resources/CutScense/lavaCut.png","src/main/resources/CutScense/Skipwhite.png"));
        BoardNnm = 0;
        themeNnm = 0;
        levelnum.add(300);
        levelnum.add(250);
        levelnum.add(200);
        level = 0;
        board.add(Arrays.asList("/skyboardEasy.txt", "/forestEasy.txt", "/caveboardEasy.txt","/iceboardEasy.txt","/lavaboardEasy.txt"));
        board.add(Arrays.asList("/skyboardNormal.txt", "/forestNormal.txt", "/caveboardNormal.txt","/iceboardNormal.txt","/lavaboardNormal.txt"));
        board.add(Arrays.asList("/skyboardHard.txt", "/forestHard.txt", "/caveboardHard.txt","/iceboardHard.txt","/lavaboardHard.txt"));
    }
    /**
     * A function that updates the current board number and
     * theme number if the game is won and advances to the next level or theme,
     * or resets the game if the last level is already completed.
     * */
    public void GemeWon(){
        if(themeNnm<4){
            BoardNnm ++;
            themeNnm ++;
        }else{
            GameReset();
            levelup =true;
        }
    }

    /**
     * A function that resets the current board and
     * theme numbers to their default values.
     * */
    public void GameReset(){
        BoardNnm = 0;
        themeNnm= 0;
    }
    /**
     *
     * A function that sets the current level to the specified number.
     * */
    public void setlevel(int num){
        level = num;
    }

    /**
     *
     * A function that returns the name of the current board.
     * */

    public String getBoardName(){
        return "/Board"+board.get(level).get(BoardNnm);
    }

    /**
     *
     * A function that returns the name of the current wall sprite.
     * */

    public String getWallName(){
        return "/sprite"+Wall.get(themeNnm);
    }
    /**
     *
     * : A function that returns the name of the current pellet sprite.
     * */
    public String getPelletName(){
        return "/sprite"+Pellet.get(themeNnm);
    }

    /**
     *A function that returns the name of the current background sprite.
     * */
    public String getBGName(){
        return "src/main/resources/sprite"+BG.get(themeNnm);
    }

    /**
     *A private function that sets the move interval
     *  for each ghost based on the current level.
     * */
    public void setlevelnpc(){
        Clyde.setMoveInterval(levelnum.get(level));
        Inky.setMoveInterval(levelnum.get(level));
        Pinky.setMoveInterval(levelnum.get(level));
        Blinky.setMoveInterval(levelnum.get(level));
    }

    public void nextCutScense(PacManUI pacManUI){
        if (levelup){
            toVictoryUI(pacManUI);
            levelup = false;
            setlevelnpc();
        } else {setlevelnpc();
        CutScense cutScense = getCutScense();
        cutScense.setPacManUI(pacManUI);
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(cutScense.getCutscenseUI());
        pacManUI.pack();}
    }

    public CutScense getCutScense(){
        return cut.get(themeNnm);
    }
    private void toVictoryUI(PacManUI pacManUI){
        vicetory_ui.setPacManUI(pacManUI);
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(vicetory_ui.getVictoryUI());
        pacManUI.pack();
    }

    public void toDeadscense(PacManUI pacManUI){
        deadscense.setPacManUI(pacManUI);
        pacManUI.contentPanel.removeAll();
        pacManUI.contentPanel.add(deadscense.getDeadscense());
        pacManUI.pack();
    }

    public Deadscense getDeadscense() {
        return deadscense;
    }
    public Vicetory_UI getVicetory_ui(){
        return vicetory_ui;
    }

}
