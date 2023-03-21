package nl.tudelft.jpacman.npc.level;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class PelletChangeMaptest {
    private Launcher l =new Launcher();
    @BeforeEach
    void setUp() {
        l.launch();
        l.getPacManUItest().getmain_ui().getButtonPlay().doClick();
        l.getPacManUItest().getmain_ui().getCutScense().getButtonSkip().doClick();
    }

    @AfterEach
    void tearDown() {
        l.dispose();
    }

    @DisplayName("TC1501")
    @Test
    void PelletChangeMapTest(){
        String map = "/boardTest.txt";
        setgameLauncher(map);
        while (l.getLevelMap() == "/boardTest.txt"){
            //l.delay(1);
            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());

        }

        assertThat(map!=l.getLevelMap()).isTrue();
    }

    @DisplayName("TC1701")
    @Test
    void PelletNoChanceMapTest(){
        String map = "/boardTest.txt";
        setgameLauncher(map);
        for (int i = 0; i < 30; i++){
            //l.delay(5);
            l.getGame().move(l.getGame().getPlayers().get(0),randomMove());
        }
        assertThat(map==l.levelMap).isTrue();
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
