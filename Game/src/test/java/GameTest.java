import org.bowlingGame.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest
{
    private Game game;

    @BeforeEach
    public void newGame(){

        game = new Game();
    }

    @Test
    void canScoreFailedGame(){
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(0,game.score());
    }

    @Test
    void canScoreGameOfOnes(){
        game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);

        assertEquals(20,game.score());
    }

    @Test
    void canScoreSpare(){
        game.roll(5,5, 4,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(18,game.score());

    }

    @Test
    void rollStrike(){
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(3);
        game.roll(4);

        assertEquals(77,game.score());
    }

    @Test
    void rollStrikeTenthFrame(){

        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(10);
        game.roll(5);
        game.roll(3);

        assertEquals(18,game.score());

    }

    @Test
    void rollSpareTenthFrame(){

        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(5);
        game.roll(5);
        game.roll(3);

        assertEquals(13,game.score());

    }

    @Test
    void rollAllStrikes(){



        assertEquals(300,game.score());

    }
}
