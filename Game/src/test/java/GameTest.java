import org.bowlingGame.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest
{
    Game game = new Game();

    @Test
    void rollPinsDown(){
        game.roll(1);
        game.roll(2);
        assertEquals(3,game.score());
    }

    @Test
    void rollSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        assertEquals(13,game.score());

    }


}
