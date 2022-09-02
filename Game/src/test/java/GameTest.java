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
    void canScoreStrike(){
        game.roll(10, 5,4, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(33,game.score());
    }

    @Test
    void canScoreStrikeAfterStrike(){
        game.roll(10, 10, 5,4, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(53,game.score());
    }

    @Test
    void canRollStrikeBonusInTenthFrame(){

        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10,5,3);

        assertEquals(18,game.score());
    }

    @Test
    void canRollSpareBonusInTenthFrame(){

        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 5,5,3);

        assertEquals(13,game.score());
    }

    @Test
    void canScorePerfectGame(){

        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

        assertEquals(300,game.score());
    }

    @Test
    void canHandleNegativeNumbers(){

        game.roll(-1,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(-1,game.score());
    }
}
