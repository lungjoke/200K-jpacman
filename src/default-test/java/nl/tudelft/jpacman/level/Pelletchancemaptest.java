package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Pelletchancemaptest {
    private Launcher l =new Launcher();
    @BeforeEach
    void setUp() {
        l.launch();
        l.getPacManUItest().buttonPlay.doClick();
    }

    @Test
    void Pelletchancemaptest(){
        List<Direction> Move_D = Arrays.asList(Direction.NORTH,Direction.SOUTH,Direction.EAST,Direction.WEST);
        Launcher l = new Launcher();
        l.launch();
        l.getPacManUItest().buttonPlay.doClick();
        String map = "/boardTest.txt";
        l.levelMap = map;
        l.makeGame();
        l.setlaunchGame();
        l.getPacManUItest().newMap(l.getGame(),"src/main/resources/sprite/BGForest.png");
        l.getGame().start();
        Random random = new Random();
        while (l.getLevelMap() == "/boardTest.txt"){
            l.getGame().move(l.getGame().getPlayers().get(0),Move_D.get(random.nextInt(Move_D.size())));
        }
        assertThat(map!=l.getLevelMap()).isTrue();
    }
    @Test
    void PelletNoChancemaptest(){
        List<Direction> Move_D = Arrays.asList(Direction.NORTH,Direction.SOUTH,Direction.EAST,Direction.WEST);
        Launcher l = new Launcher();
        l.launch();
        l.getPacManUItest().buttonPlay.doClick();
        String map = "/boardTest.txt";
        l.levelMap = map;
        l.makeGame();
        l.setlaunchGame();
        l.getPacManUItest().newMap(l.getGame(),"src/main/resources/sprite/BGForest.png");
        l.getGame().start();
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            l.getGame().move(l.getGame().getPlayers().get(0),Move_D.get(random.nextInt(Move_D.size())));
        }
        assertThat(map==l.getLevelMap()).isTrue();
    }

    @Test
    void PelletDead(){
        List<Direction> Move_D = Arrays.asList(Direction.NORTH,Direction.SOUTH,Direction.EAST,Direction.WEST);
        Launcher l = new Launcher();
        l.launch();
        l.getPacManUItest().buttonPlay.doClick();
        String map = "/boardTest1.txt";
        l.levelMap = map;
        l.makeGame();
        l.setlaunchGame();
        l.getPacManUItest().newMap(l.getGame(),"src/main/resources/sprite/BGForest.png");
        l.getGame().start();
        Random random = new Random();
        while (l.getLevelMap()!="/skyboard.txt"){
            l.getGame().move(l.getGame().getPlayers().get(0),Move_D.get(random.nextInt(Move_D.size())));
        }
        assertThat(l.getLevelMap()=="/skyboard.txt").isTrue();
    }
}
