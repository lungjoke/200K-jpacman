package nl.tudelft.jpacman.npc.integration;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestSprint_2 {

    private Launcher l =new Launcher();
    @BeforeEach
    void setUp() {
        l.launch();
        l.getPacManUItest().getmain_ui().getButton2().doClick();
    }
    @AfterEach
    void tearDown() {
        l.dispose();
    }
    @Test
    void Sprint(){
        setgameLauncher("/skyboard.txt");
        while (l.getLevelMap() == "/skyboard.txt"){

            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        setgameLauncher("/forest.txt");
        while (l.getLevelMap() == "/forest.txt"){

            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        setgameLauncher("/caveboard.txt");
        while (l.getLevelMap() == "/caveboard.txt"){

            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        setgameLauncher("/iceboard.txt");
        while (l.getLevelMap() == "iceboard.txt"){

            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        setgameLauncher("/lavaboard.txt");
        while (l.getLevelMap() == "/lavaboard.txt"){

            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        System.out.println(l.getLevelMap());
    }

    public void setgameLauncher(String map){
        l.levelMap = map;
        l.makeGame();
        l.getGame().setLauncher(l);
        l.getPacManUItest().newMap(l.getGame(),l.getPacManUItest().getNameBG());
        l.getGame().start();
    }
    public Direction randomMove(){
        List<Direction> Move_D = Arrays.asList(Direction.NORTH,Direction.SOUTH,Direction.EAST,Direction.WEST);
        Random random = new Random();
        return Move_D.get(random.nextInt(Move_D.size()));
    }
}
